/**
 * 
 */
package pagecode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;

import com.Beans.TarifelerBean;
import com.DB.DBConnection;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.ibm.faces.component.html.HtmlOutputLinkEx;
import com.ibm.faces.component.html.HtmlScriptCollector;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * @author Mehmet
 * 
 */
public class KullaniciEkle extends PageCodeBase {

	protected HtmlScriptCollector scriptCollector1;
	protected HtmlOutputLinkEx linkEx1;
	protected HtmlOutputText text1;
	protected HtmlOutputLinkEx linkEx2;
	protected HtmlOutputText text2;
	protected HtmlOutputLinkEx linkEx3;
	protected HtmlOutputText text3;
	protected HtmlOutputLinkEx linkEx4;
	protected HtmlOutputText text4;
	protected HtmlOutputText outtxtName;
	protected HtmlInputText intxtAdSoyad;
	protected HtmlForm form1;
	protected HtmlOutputText outtxtYas;
	protected HtmlInputText intxtYas;
	protected HtmlOutputLinkEx linkEx5;
	protected HtmlOutputText text5;
	protected HtmlCommandExButton btnKaydet;
	protected HtmlOutputText outtxtError;
	List<TarifelerBean> list_tarifeler;

	String adSoyad;
	String yas;
	int tarife_id;
	String deger = "1";
	String basTarihi;
	String bitisTarihi;
	String errorMessage;
	String aramaAD;
	int aramaYAS;
	int uye_id2;
	protected int katSayi = 0;

	// Kaydet butonu tetiklendiginde input'lardan alınan degerler uyeler
	// tablosuna insert edilir.
	// Tarih default sistemin o anki saatini uyeligin baslangıc tarihine atar.
	public String doBtnKaydetAction() {
		Connection conn = null;
		PreparedStatement ps = null;
		final SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		basTarihi = df.format(new Date());
		System.out.println("TARIH" + basTarihi);
		System.out.println("DEGER :" + deger);
		if (getAdSoyad().equals("") || getYas().equals("")) {
			errorMessage = "Ad Soyad ve Yas bos birakilamaz.";
			return "";
		} else {
			System.out.println("Tarih:" + basTarihi);
			int yas2 = Integer.parseInt(yas);
			int deger2 = Integer.parseInt(deger);
			if (yas2 >= 16 && getAdSoyad().length() >= 3) {
				try {
					String sql = "INSERT INTO GYM_UYELER(ADSOYAD,YAS) VALUES(?,?)";
					conn = DBConnection.getConnection();
					ps = conn.prepareStatement(sql);
					ps.setString(1, adSoyad);
					ps.setInt(2, yas2);
					int result = ps.executeUpdate();
					if (result > 0) {
						aramaAD = adSoyad;

						System.out.println(aramaAD);
						adSoyad = "";
						yas = "";
						basTarihi = "";
						errorMessage = "KAYIT BASARI ILE OLUSTURULDU";
						insert_kart(aramaAD);

					} else {
						System.out.println("KAYIT BASARISIZ");
						return "";
					}

				} catch (Exception e) {
					System.out.println("Exception ex " + e.toString());
				} finally {
					try {
						conn.close();
						ps.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			} else {
				errorMessage = "Ad ve Soyad 6 karakterden uzun olmalidir. Yas ise 16 dan buyuk olmalidir.";
				return "";
			}

		}
		return "";
	}

	// Her yeni uye icin bir kart insert eder. Aynı işi gören trigger
	// tanımlanabilir.
	public void insert_kart(String aranan) {
		Connection conn = null;
		PreparedStatement ps = null, ps2 = null;
		ResultSet result = null;
		try {
			String aranacak = "%" + aranan + "%";
			conn = DBConnection.getConnection();
			String sql = "SELECT UYE_ID FROM GYM_UYELER WHERE ADSOYAD LIKE ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, aranacak);
			result = ps.executeQuery();
			while (result.next()) {
				String sql2 = "INSERT INTO GYM_KARTLAR (UYE_ID) VALUES(?)";
				ps2 = conn.prepareStatement(sql2);
				ps2.setInt(1, result.getInt("UYE_ID"));
				uye_id2 = result.getInt("UYE_ID");
				int rs = ps2.executeUpdate();
				if (rs > 0) {
					System.out.println("INSERTED");
					insert_aktifler(uye_id2);
					
				}
				
			}
		} catch (Exception e) {
			System.out.println("SQL EXCEPTION :" + e.toString());
		} finally {
			try {
				conn.close();
				ps.close();
				result.close();
				ps2.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	

	//Her yeni bir kullanıcıya kart_id atandıgında insert_aktifler fonk çalışır ve aktiflere uyeyi pasif olarak atar.
	public void insert_aktifler(int id){
		Connection conn = null;
		PreparedStatement ps = null,ps2 = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT KART_ID FROM GYM_KARTLAR WHERE UYE_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next()){
				sql = "INSERT INTO GYM_AKTIFLER(KART_ID) VALUES(?)";
				ps2 = conn.prepareStatement(sql);
				ps2.setInt(1, rs.getInt("KART_ID"));
				
				int result = ps2.executeUpdate();
				if(result > 0){
					System.out.println("INSERTED-2");
					//insert_kullanicitarifeler(uye_id2);
				}
				
			}
		} catch (Exception e) {
			System.out.println("insert_aktifer exception :" + e.toString());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				rs.close();
				ps2.close();
				ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	// tarife_cmb_doldur methodu combobox'ın valuesine tarifeler tablosunun
	// id'sini label kısmına ise adını atar.
	public void tarife_cmb_doldur() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		list_tarifeler = new ArrayList<TarifelerBean>();
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT TARIFE_ID,TARIFEAD FROM GYM_TARIFELER";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				TarifelerBean tb = new TarifelerBean();
				tb.setTarife_id(rs.getInt("TARIFE_ID"));
				tb.setAd(rs.getString("TARIFEAD"));
				list_tarifeler.add(tb);
			}

		} catch (Exception e) {
			System.out.println("Tarife Cmb Doldurma Hatasi :" + e.toString());
		} finally {
			try {
				conn.close();
				ps.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	//tetiklenince kullanicitarifeler tablosuna uye_id ye gore tarife id ekler. 
	public void insert_kullanicitarifeler(int id){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "INSERT INTO GYM_KULLANICITARIFELER(UYE_ID,TARIFE_ID) VALUES(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.setInt(2,tarife_id);
			int rs = ps.executeUpdate();
			if(rs > 0){
				System.out.println("Kayit basarili");
			}
		} catch (Exception e) {
			System.out.println("insert_kullanicitarifeler :" + e.toString());
			e.printStackTrace();
		}
	}
	// TODO KOD AYRIMI
	public int getUye_id2() {
		return uye_id2;
	}

	public void setUye_id2(int uye_id2) {
		this.uye_id2 = uye_id2;
	}
	public String getDeger() {
		return deger;
	}

	public void setDeger(String deger) {
		this.deger = deger;
	}

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public String getYas() {
		return yas;
	}

	public void setYas(String yas) {
		this.yas = yas;
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

	public List<TarifelerBean> getList_tarifeler() {
		tarife_cmb_doldur();
		return list_tarifeler;
	}

	public void setList_tarifeler(List<TarifelerBean> list_tarifeler) {
		this.list_tarifeler = list_tarifeler;
	}

	protected HtmlScriptCollector getScriptCollector1() {
		if (scriptCollector1 == null) {
			scriptCollector1 = (HtmlScriptCollector) findComponentInRoot("scriptCollector1");
		}
		return scriptCollector1;
	}

	protected HtmlOutputLinkEx getLinkEx1() {
		if (linkEx1 == null) {
			linkEx1 = (HtmlOutputLinkEx) findComponentInRoot("linkEx1");
		}
		return linkEx1;
	}

	protected HtmlOutputText getText1() {
		if (text1 == null) {
			text1 = (HtmlOutputText) findComponentInRoot("text1");
		}
		return text1;
	}

	protected HtmlOutputLinkEx getLinkEx2() {
		if (linkEx2 == null) {
			linkEx2 = (HtmlOutputLinkEx) findComponentInRoot("linkEx2");
		}
		return linkEx2;
	}

	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}

	protected HtmlOutputLinkEx getLinkEx3() {
		if (linkEx3 == null) {
			linkEx3 = (HtmlOutputLinkEx) findComponentInRoot("linkEx3");
		}
		return linkEx3;
	}

	protected HtmlOutputText getText3() {
		if (text3 == null) {
			text3 = (HtmlOutputText) findComponentInRoot("text3");
		}
		return text3;
	}

	protected HtmlOutputLinkEx getLinkEx4() {
		if (linkEx4 == null) {
			linkEx4 = (HtmlOutputLinkEx) findComponentInRoot("linkEx4");
		}
		return linkEx4;
	}

	protected HtmlOutputText getText4() {
		if (text4 == null) {
			text4 = (HtmlOutputText) findComponentInRoot("text4");
		}
		return text4;
	}

	protected HtmlOutputText getOuttxtName() {
		if (outtxtName == null) {
			outtxtName = (HtmlOutputText) findComponentInRoot("outtxtName");
		}
		return outtxtName;
	}

	protected HtmlInputText getIntxtAdSoyad() {
		if (intxtAdSoyad == null) {
			intxtAdSoyad = (HtmlInputText) findComponentInRoot("intxtAdSoyad");
		}
		return intxtAdSoyad;
	}

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected HtmlOutputText getOuttxtYas() {
		if (outtxtYas == null) {
			outtxtYas = (HtmlOutputText) findComponentInRoot("outtxtYas");
		}
		return outtxtYas;
	}

	protected HtmlInputText getIntxtYas() {
		if (intxtYas == null) {
			intxtYas = (HtmlInputText) findComponentInRoot("intxtYas");
		}
		return intxtYas;
	}

	public int getTarife_id() {
		return tarife_id;
	}

	public void setTarife_id(int tarife_id) {
		this.tarife_id = tarife_id;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	protected HtmlOutputLinkEx getLinkEx5() {
		if (linkEx5 == null) {
			linkEx5 = (HtmlOutputLinkEx) findComponentInRoot("linkEx5");
		}
		return linkEx5;
	}

	protected HtmlOutputText getText5() {
		if (text5 == null) {
			text5 = (HtmlOutputText) findComponentInRoot("text5");
		}
		return text5;
	}

	protected HtmlCommandExButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = (HtmlCommandExButton) findComponentInRoot("btnKaydet");
		}
		return btnKaydet;
	}

	protected HtmlOutputText getOuttxtError() {
		if (outtxtError == null) {
			outtxtError = (HtmlOutputText) findComponentInRoot("outtxtError");
		}
		return outtxtError;
	}

}