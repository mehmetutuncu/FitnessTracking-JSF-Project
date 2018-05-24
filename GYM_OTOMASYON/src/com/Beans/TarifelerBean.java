package com.Beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TarifelerBean {
	private String ad;
	private int tarife_id;
	private int fiyat;
	private String basTarihi;
	private String bitisTarihi;
	private int ay;
	

	public String getKalanHesap() throws ParseException{
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Date baslangic = df.parse(basTarihi);
		long fark = now.getTime() - baslangic.getTime();
		long fark_gun = TimeUnit.DAYS.convert(fark, TimeUnit.MILLISECONDS);
		System.out.println(fark_gun+"gun");
		System.out.println(ay*30);
		if(fark_gun > (ay*30)){
			
			return "Uyelik Sonlandi";
		}
		else{
			
			return "Uyelik Devam Etmektedir.";
		}
		
		
		
	}
	public int getAy() {
		return ay;
	}

	public void setAy(int ay) {
		this.ay = ay;
	}
	
	public String getBasTarihi() {
		return basTarihi;
	}
	public void setBasTarihi(String basTarihi) {
		this.basTarihi = basTarihi;
	}
	public String getBitisTarihi() {
		return bitisTarihi;
	}
	public void setBitisTarihi(String bitisTarihi) {
		this.bitisTarihi = bitisTarihi;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public int getTarife_id() {
		return tarife_id;
	}
	public void setTarife_id(int tarife_id) {
		this.tarife_id = tarife_id;
	}
	public int getFiyat() {
		return fiyat;
	}
	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}
}

