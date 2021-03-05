package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.OfferDao;
import kr.ac.hansung.model.Offer;

@Service
public class OfferService {
	
	@Autowired
	private OfferDao offerDao;
	
	/*
	 * public List<Offer> getCurrent() { return offerDao.getOffers(); }
	 */

	public void insert(Offer offer) {
		offerDao.insert(offer); //DB에 저장
		
	}
	//학년/학기별 이수 총 학점
	public List<Offer> getGrade() {
		return offerDao.getGrade();
	}
	//링크 클릭시
	public List<Offer> getOffer(int year, int semester) {
		return offerDao.getOffer(year, semester);
	}
	//수강신청내역조회
	public List<Offer> getOffers() {
		return offerDao.getOffers();
	}
}
