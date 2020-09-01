package com.rando.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.rando.dao.EtapeDao;
import com.rando.dto.EtapeDto;
import com.rando.modele.Etape;

@Service
public class EtapeService {

	@Autowired
	EtapeDao etapeDao;


	public List<Etape> getAllEtapes() {
		return etapeDao.getAllEtapes();
	}

	public Etape getEtape(int etapeId) {
		return etapeDao.getEtape(etapeId);
	}

	@Transactional
	public void ajouter(EtapeDto etapeDto) throws EtapeExisteDejaException {
		if(etapeDto != null) {
			if(etapeDao.existe(etapeDto.getNom()))
				throw new EtapeExisteDejaException("L'étape existe déjà");
			Etape nEtape = new Etape();
			try {
				nEtape.setNom(etapeDto.getNom());
				nEtape.setLongitude(etapeDto.getLongitude());
				nEtape.setLatitude(etapeDto.getLatitude());
				nEtape.setDescription(etapeDto.getDescription());
				//nEtape.setQrCode(generateQRCodeImage(etapeDto.getNom()+etapeDto.getDescription()+etapeDto.getLatitude()+etapeDto.getLongitude()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}



	}

	@Transactional
	public void modifier(EtapeDto etapeDto) {
		Etape nEtape = etapeDao.getEtape(etapeDto.getId());
		if(nEtape != null) {
			try {
				nEtape.setNom(etapeDto.getNom());
				nEtape.setLongitude(etapeDto.getLongitude());
				nEtape.setLatitude(etapeDto.getLatitude());
				nEtape.setDescription(etapeDto.getDescription());
				//nEtape.setQrCode(generateQRCodeImage(etapeDto.getNom()+etapeDto.getDescription()+etapeDto.getLatitude()+etapeDto.getLongitude()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Transactional(rollbackFor = EtapeEncoreDansUnItineraireException.class)
	public void supprimer(int id) throws EtapeEncoreDansUnItineraireException{
		Etape etape = etapeDao.getEtape(id);
		if(etape == null)
			return;
		if(!etape.getEtapeitineraires().isEmpty())
			throw new EtapeEncoreDansUnItineraireException("L'étape que vous tentez de supprimer est comprise dans un itineraire veuillez le supprimer d'abord");
		etapeDao.supprimer(id);
		// TODO Auto-generated method stub

	}



}
