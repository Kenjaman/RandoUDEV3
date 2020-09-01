package com.rando.controleur;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
public class EtapeControlleur {

	@Autowired
	private EtapeService etapeService;
	@Autowired
	private DataSource dataSource;

	//Consultation

	@GetMapping("/etapes")
	public String getListeEtapes(Model model) {
		model.addAttribute("etapes", etapeService.getAllEtapes());
		return "etapes";
	}

	@GetMapping("/etape/{etapeId}")
	public String getDetailEtape(Model model,@PathVariable int etapeId) {
		model.addAttribute("etape",etapeService.getEtape(etapeId));
		return "etape";	
	}

	//Creation

	@GetMapping("/ajoutEtape")
	public String ajouterEtape(Model model, @ModelAttribute EtapeDto etapeDto) {
		model.addAttribute("etapes",etapeService.getAllEtapes());
		return "ajouterEtape";

	}

	@PostMapping("/ajoutEtape")
	public String ajouterEtape(Model model, @Valid @ModelAttribute EtapeDto etapeDto, BindingResult bindingResult) {
		if(bindingResult.hasErrors() || model.getAttribute("erreurs")!=null) {
			System.out.println("ya une erreur");
			return ajouterEtape(model, etapeDto);
		}else {
			try {
				etapeService.ajouter(etapeDto);
				return "redirect:/etapes";
			} catch (EtapeExisteDejaException e) {
				model.addAttribute("erreurs",e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ajouterEtape(model, etapeDto);
			}
		}
	}

	@PostMapping("/ajoutEtapeJS")
	public String ajouterEtapeJS(Model model, @Valid @ModelAttribute EtapeDto etapeDto, BindingResult bindingResult) {
		if(bindingResult.hasErrors() || model.getAttribute("erreurs")!=null) {
			System.out.println("ya une erreur");
			return ajouterEtapeJS(model, etapeDto,bindingResult);
		}else {
			try {
				etapeService.ajouter(etapeDto);
			} catch (EtapeExisteDejaException e) {
				model.addAttribute("erreurs",e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "ok";
		}
	}

	//Modification

	@GetMapping("/modifEtape/{etapeId}")
	public String modifierEtape(Model model,@PathVariable int etapeId) {
		model.addAttribute("etape",etapeService.getEtape(etapeId));
		return "etape";	
	}

	@PostMapping("/modifEtape/{etapeId}")
	public String modifierEtape(Model model,@PathVariable long etapeId, @Valid @ModelAttribute EtapeDto etapeDto,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("ya une erreur");
			return "modifierEtape";
		}else {
			etapeService.modifier(etapeDto);
			return "redirect:/etape/"+etapeId;
		}
	}


	//Suppression

	@PostMapping("/etape/suppression")
	public String supprimerEtape(Model model,@ModelAttribute EtapeDto etapeDto) {
		//TODO Suppression d'Etape
		try {
			etapeService.supprimer(etapeDto.getId());
		} catch (EtapeEncoreDansUnItineraireException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/etapes";
	}

	//Generation QR_Code PDF 
	@GetMapping(path="etape/qrcode.pdf", produces = "application/pdf")
	public void produireFicheEtape(OutputStream out) {
		//TODO
		try(Connection connection = dataSource.getConnection()) {
			InputStream modeleInputStream = this.getClass().getResourceAsStream("/qr_code.jrxml");
			JasperReport rapport = JasperCompileManager.compileReport(modeleInputStream);
			Map<String, Object> parameters = new HashMap<>();
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
