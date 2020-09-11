package com.rando.controleur;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.rando.dto.CommentaireDto;
import com.rando.dto.EtapeDto;
import com.rando.modele.Niveau;
import com.rando.service.EtapeEncoreDansUnItineraireException;
import com.rando.service.EtapeExisteDejaException;
import com.rando.service.EtapeService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Controller
public class EtapeControleur {

	@Autowired
	private EtapeService etapeService;
	@Autowired
	private DataSource dataSource;

	// Consultation

	@GetMapping("/etapes")
	public String getListeEtapes(Model model, HttpSession session) {
		session.setAttribute("nbEtapes", etapeService.getAllEtapes().size());
		model.addAttribute("etapes", etapeService.getAllEtapes());
		return "etapes";
	}

	@GetMapping("/etape/detail/{etapeId}")
	public String getDetailEtape(Model model, @PathVariable int etapeId,@ModelAttribute CommentaireDto commentaireDto) {
		model.addAttribute("etape", etapeService.getEtape(etapeId));
		return "etape";
	}
	
	@GetMapping("/etape/view/{etapeId}")
	public ModelAndView getEtapeClient(@PathVariable int etapeId) {
		return new ModelAndView("etapeRandonneur", "etape", etapeService.getEtape(etapeId));
	}

	// Creation

	@GetMapping("/ajoutEtape")
	public String ajouterEtape(Model model, @ModelAttribute EtapeDto etapeDto) {
		model.addAttribute("etapes", etapeService.getAllEtapes());
		return "ajouterEtape";

	}

	@PostMapping("/ajoutEtape")
	public String ajouterEtape(Model model, @Valid @ModelAttribute EtapeDto etapeDto, BindingResult bindingResult,
			HttpSession session) {
		if (bindingResult.hasErrors() || model.getAttribute("erreurs") != null) {
			System.out.println("ya une erreur");
			return ajouterEtape(model, etapeDto);
		} else {
			try {
				int idCreer = etapeService.ajouter(etapeDto);
				session.setAttribute("nbEtapes", etapeService.getAllEtapes().size());
				return "redirect:/etape/" + idCreer;
			} catch (EtapeExisteDejaException e) {
				model.addAttribute("erreurs", e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ajouterEtape(model, etapeDto);
			}
		}
	}

//	@PostMapping("/ajoutEtapeJS")
//	public String ajouterEtapeJS(Model model, @Valid @ModelAttribute EtapeDto etapeDto, BindingResult bindingResult) {
//		if(bindingResult.hasErrors() || model.getAttribute("erreurs")!=null) {
//			System.out.println("ya une erreur");
//			return ajouterEtapeJS(model, etapeDto,bindingResult);
//		}else {
//			try {
//				etapeService.ajouter(etapeDto);
//			} catch (EtapeExisteDejaException e) {
//				model.addAttribute("erreurs",e.getMessage());
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return "ok";
//		}
//	}

	// Modification

	@GetMapping("/modifEtape/{etapeId}")
	public String modifierEtape(Model model, @PathVariable int etapeId, @ModelAttribute EtapeDto etapeDto) {
		model.addAttribute("etapeDto", etapeService.getEtape(etapeId));
		return "ajouterEtape";
	}

	@PostMapping("/modifEtape")
	public String modifierEtape(Model model, @RequestParam Integer id, @Valid @ModelAttribute EtapeDto etapeDto,
			BindingResult bindingResult) {
		System.out.println("ID =>>> " + id);
		if (bindingResult.hasErrors()) {
			System.out.println("ya une erreur sur " + id);
			return "modifierEtape";
		} else {
			etapeService.modifier(id, etapeDto);
			return "redirect:/etape/" + id;
		}
	}

	// Suppression

	@PostMapping("/etape/suppression/{etapeId}")
	public String supprimerEtape(Model model, @PathVariable Integer etapeId, HttpSession session) {
		try {
			etapeService.supprimer(etapeId);
			session.setAttribute("nbEtapes", etapeService.getAllEtapes().size());
			return "redirect:/etapes";
		} catch (EtapeEncoreDansUnItineraireException e) {
			model.addAttribute("MsgEchecSuppression", e.getMessage());
			return "etapes";
		}
	}

	// Generation QR_Code PDF
	@GetMapping(path = "etape/{etapeId}/qrcode.pdf", produces = "application/pdf")
	public void produireFicheEtape(OutputStream out, Model model, @PathVariable Integer etapeId) {
		// TODO
		try (Connection connection = dataSource.getConnection()) {
			InputStream modeleInputStream = this.getClass().getResourceAsStream("/QrCodeEtape.jrxml");
			JasperReport rapport = JasperCompileManager.compileReport(modeleInputStream);
			Map<String, Object> parameters = new HashMap<>();
			UriComponentsBuilder uri = MvcUriComponentsBuilder.fromMethodName(EtapeControleur.class, "getEtapeClient",etapeId);
			System.out.println("uri du qrcode : " + uri.toUriString());
			parameters.put("URI", uri.toUriString());
			parameters.put("ID", etapeId);
			parameters.put("AUTEUR", "GROUPE1");
			JasperPrint print = JasperFillManager.fillReport(rapport, parameters, connection);

			JRPdfExporter pdfExporter = new JRPdfExporter();
			pdfExporter.setExporterInput(new SimpleExporterInput(print));
			pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(out));
			pdfExporter.exportReport();
		} catch (SQLException | JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
