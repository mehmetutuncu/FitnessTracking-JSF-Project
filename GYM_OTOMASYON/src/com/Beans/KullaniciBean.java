package com.Beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class KullaniciBean {
	
	private int kartId;
	private String tarifeAd;
	private String adSoyad;
	private boolean sureKontrol;
	private int yas;
	private String basTarihi;
	private int ay;
	private int fiyat;
	private int uye_id;

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
	public int getFiyat() {
		return fiyat;
	}
	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}
	public String getBasTarihi() {
		return basTarihi;
	}
	public void setBasTarihi(String basTarihi) {
		this.basTarihi = basTarihi;
	}
	public int getAy() {
		return ay;
	}
	public void setAy(int ay) {
		this.ay = ay;
	}
	public int getYas() {
		return yas;
	}
	public void setYas(int yas) {
		this.yas = yas;
	}
	public int getKartId() {
		return kartId;
	}
	public void setKartId(int kartId) {
		this.kartId = kartId;
	}
	public String getTarifeAd() {
		return tarifeAd;
	}
	public void setTarifeAd(String tarifeAd) {
		this.tarifeAd = tarifeAd;
	}
	public String getAdSoyad() {
		return adSoyad;
	}
	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}
	public boolean getSureKontrol() {
		return sureKontrol;
	}
	public void setSureKontrol(boolean sureKontrol) {
		this.sureKontrol = sureKontrol;
	}
	public int getUye_id() {
		return uye_id;
	}
	public void setUye_id(int uye_id) {
		this.uye_id = uye_id;
	}

}
