/**
 * 
 */
package pagecode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;

import com.Beans.TarifelerBean;
import com.Beans.UserBean;
import com.DB.DBConnection;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.ibm.faces.component.html.HtmlOutputLinkEx;
import com.ibm.faces.component.html.HtmlScriptCollector;
import com.ibm.faces.component.html.HtmlDataTableEx;
import com.ibm.faces.component.UIColumnEx;

/**
 * @author Mehmet
 * 
 */

public class UyeDuzenle extends PageCodeBase {
	protected HtmlScriptCollector scriptCollector1;
	protected HtmlOutputLinkEx linkEx1;
	protected HtmlOutputText text1;
	protected HtmlForm form1;
	protected HtmlSelectOneMenu menu1;
	protected HtmlOutputText outTxtAdSoyad;
	protected HtmlInputText inttxtAdSoyad;
	protected HtmlCommandExButton btnGetir;
	protected HtmlOutputText outtxtYas;
	protected HtmlInputText inttxtYas;
	protected HtmlCommandExButton btnGuncelle;
	protected HtmlOutputText text3;
	protected HtmlOutputText outtxtMessage;
	protected int uye_id;
	protected String adSoyad;
	protected int yas;
	protected int tarife_id;
	List<UserBean> list_uyeInfo;
	protected String tarih;
	protected Date now;
	protected String tarifead;
	String mesaj;
	ArrayList<TarifelerBean> kullanici_tarife_list;
	protected HtmlDataTableEx kullanici_tarife_list1;
	protected UIColumnEx ad1column;
	protected HtmlOutputText ad1text;
	protected HtmlOutputText ay1text;
	protected HtmlOutputText basTarihi1text;
	protected HtmlOutputText kalanHesap1text;
	protected HtmlOutputText ad1;
	protected UIColumnEx ay1column;
	protected HtmlOutputText ay1;
	protected UIColumnEx basTarihi1column;
	protected HtmlOutputText basTarihi1;
	protected UIColumnEx kalanHesap1column;
	protected HtmlOutputText kalanHesap1;
	// Getir butonuna basıldıgında comboboxdan secili olan uye id'ye ait
	// bilgiler gelir.
	public String doBtnGetirAction() {
		kullanici_tarife_list  = new ArrayList<TarifelerBean>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT GKT.AY , GU.ADSOYAD, GKT.TARIFE_ID,GU.YAS, GT.TARIFEAD , GKT.BASTARIHI FROM GYM_TARIFELER GT,GYM_KULLANICITARIFELER GKT,GYM_UYELER GU WHERE GU.UYE_ID = ? and  GKT.TARIFE_ID = GT.TARIFE_ID and GU.UYE_ID = GKT.UYE_ID";
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uye_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				TarifelerBean tb = new TarifelerBean();
				setAdSoyad(rs.getString("ADSOYAD"));
				setYas(rs.getInt("YAS"));
				tb.setAd(rs.getString("TARIFEAD"));
				tb.setBasTarihi(rs.getString("BASTARIHI"));
				tb.setAy(rs.getInt("AY"));
				kullanici_tarife_list.add(tb);
				mesaj = "Uye bilgileri basari ile yuklendi";
			}
			
		} catch (Exception e) {
			System.out.println("Buton getir action exception :" + e.toString());
			e.printStackTrace();
		} finally { // Method sonunda finally girmek zorunda. Bu yuzden baglantı
					// burada kapatılıyor.
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return "";
	}

	public ArrayList<TarifelerBean> getKullanici_tarife_list() {
		return kullanici_tarife_list;
	}

	public void setKullanici_tarife_list(ArrayList<TarifelerBean> kullanici_tarife_list) {
		this.kullanici_tarife_list = kullanici_tarife_list;
	}

	

	// uyeInfoGetir uyelerin combobox'ını doldurur.
	public void uyeInfoGetir() {
		Connection conn = null;
		PreparedStatement ps = null;
		list_uyeInfo = new ArrayList<UserBean>();

		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT UYE_ID,ADSOYAD FROM GYM_UYELER ";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserBean ub = new UserBean();
				ub.setUye_id(rs.getInt("UYE_ID"));
				ub.setAdSoyad(rs.getString("ADSOYAD"));
				list_uyeInfo.add(ub);
			}
			if(list_uyeInfo.isEmpty() == true){
				mesaj = "Uye mevcut degil";
			}
			
		} catch (Exception e) {
			System.out.println("uye Info Getir Exception :" + e.toString());
			e.printStackTrace();
		} finally {// Method sonunda finally girmek zorunda. Bu yuzden baglantı
					// burada kapatılıyor.
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	// Guncelle butonu basıldıgında gerekli kontrolü yapar. Ardından girilen
	// yeni degerleri ilgili tabloya update eder.
	public String doBtnGuncelleAction() {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs; // result
		if (uye_id == 0) {
			mesaj = "Tarife id ve uye_id bos dondu";
			return "";
		} else if (getAdSoyad().length() < 6 && getAdSoyad().equals("")) {
			mesaj = "Ad ve Soyad bos gelme hatasi";
			return "";
		} else if (getYas() <= 0) {
			mesaj = "Yas 0 dan farklı olmalidir";
			return "";
		} else {
			try {
				conn = DBConnection.getConnection();
				String sql = "UPDATE GYM_UYELER SET ADSOYAD = ? ,YAS = ?  WHERE UYE_ID = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, adSoyad);
				ps.setInt(2, yas);
				ps.setInt(3, uye_id);
				rs = ps.executeUpdate();
				if (rs > 0) {
					System.out.println("Insert degeri => adSoyad : " + adSoyad + " yas : " + yas + " tarife_id : " + tarife_id + " uye_id : " + uye_id);
					adSoyad = "";
					yas = 0;
					mesaj = "Uye basari ile guncellendi";
				}
			} catch (Exception e) {

			} finally {// Method sonunda finally girmek zorunda. Bu yuzden
						// baglantı burada kapatılıyor.
				try {
					conn.close();
					ps.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

		return "";
	}


	// TODO KOD AYRIMI

	public String getMesaj() {
		return mesaj;
	}

	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	public String getTarifead() {
		return tarifead;
	}

	public void setTarifead(String tarifead) {
		this.tarifead = tarifead;
	}

	public int getTarife_id() {

		return tarife_id;
	}

	public void setTarife_id(int tarife_id) {
		this.tarife_id = tarife_id;
	}



	public List<UserBean> getList_uyeInfo() {
		uyeInfoGetir();
		return list_uyeInfo;
	}

	public void setList_uyeInfo(List<UserBean> list_uyeInfo) {
		this.list_uyeInfo = list_uyeInfo;
	}

	public int getUye_id() {
		return uye_id;
	}

	public void setUye_id(int uye_id) {
		this.uye_id = uye_id;
	}

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
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

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected HtmlSelectOneMenu getMenu1() {
		if (menu1 == null) {
			menu1 = (HtmlSelectOneMenu) findComponentInRoot("menu1");
		}
		return menu1;
	}

	protected HtmlOutputText getOutTxtAdSoyad() {
		if (outTxtAdSoyad == null) {
			outTxtAdSoyad = (HtmlOutputText) findComponentInRoot("outTxtAdSoyad");
		}
		return outTxtAdSoyad;
	}

	protected HtmlInputText getInttxtAdSoyad() {
		if (inttxtAdSoyad == null) {
			inttxtAdSoyad = (HtmlInputText) findComponentInRoot("inttxtAdSoyad");
		}
		return inttxtAdSoyad;
	}

	protected HtmlCommandExButton getBtnGetir() {
		if (btnGetir == null) {
			btnGetir = (HtmlCommandExButton) findComponentInRoot("btnGetir");
		}
		return btnGetir;
	}

	protected HtmlOutputText getOuttxtYas() {
		if (outtxtYas == null) {
			outtxtYas = (HtmlOutputText) findComponentInRoot("outtxtYas");
		}
		return outtxtYas;
	}

	protected HtmlInputText getInttxtYas() {
		if (inttxtYas == null) {
			inttxtYas = (HtmlInputText) findComponentInRoot("inttxtYas");
		}
		return inttxtYas;
	}

	protected HtmlCommandExButton getBtnGuncelle() {
		if (btnGuncelle == null) {
			btnGuncelle = (HtmlCommandExButton) findComponentInRoot("btnGuncelle");
		}
		return btnGuncelle;
	}

	protected HtmlOutputText getOuttxtMessage() {
		if (outtxtMessage == null) {
			outtxtMessage = (HtmlOutputText) findComponentInRoot("outtxtMessage");
		}
		return outtxtMessage;
	}

	protected HtmlDataTableEx getKullanici_tarife_list1() {
		if (kullanici_tarife_list1 == null) {
			kullanici_tarife_list1 = (HtmlDataTableEx) findComponentInRoot("kullanici_tarife_list1");
		}
		return kullanici_tarife_list1;
	}

	protected UIColumnEx getAd1column() {
		if (ad1column == null) {
			ad1column = (UIColumnEx) findComponentInRoot("ad1column");
		}
		return ad1column;
	}

	protected HtmlOutputText getAd1text() {
		if (ad1text == null) {
			ad1text = (HtmlOutputText) findComponentInRoot("ad1text");
		}
		return ad1text;
	}

	protected HtmlOutputText getAy1text() {
		if (ay1text == null) {
			ay1text = (HtmlOutputText) findComponentInRoot("ay1text");
		}
		return ay1text;
	}

	protected HtmlOutputText getBasTarihi1text() {
		if (basTarihi1text == null) {
			basTarihi1text = (HtmlOutputText) findComponentInRoot("basTarihi1text");
		}
		return basTarihi1text;
	}

	protected HtmlOutputText getKalanHesap1text() {
		if (kalanHesap1text == null) {
			kalanHesap1text = (HtmlOutputText) findComponentInRoot("kalanHesap1text");
		}
		return kalanHesap1text;
	}

	protected HtmlOutputText getAd1() {
		if (ad1 == null) {
			ad1 = (HtmlOutputText) findComponentInRoot("ad1");
		}
		return ad1;
	}

	protected UIColumnEx getAy1column() {
		if (ay1column == null) {
			ay1column = (UIColumnEx) findComponentInRoot("ay1column");
		}
		return ay1column;
	}

	protected HtmlOutputText getAy1() {
		if (ay1 == null) {
			ay1 = (HtmlOutputText) findComponentInRoot("ay1");
		}
		return ay1;
	}

	protected UIColumnEx getBasTarihi1column() {
		if (basTarihi1column == null) {
			basTarihi1column = (UIColumnEx) findComponentInRoot("basTarihi1column");
		}
		return basTarihi1column;
	}

	protected HtmlOutputText getBasTarihi1() {
		if (basTarihi1 == null) {
			basTarihi1 = (HtmlOutputText) findComponentInRoot("basTarihi1");
		}
		return basTarihi1;
	}

	protected UIColumnEx getKalanHesap1column() {
		if (kalanHesap1column == null) {
			kalanHesap1column = (UIColumnEx) findComponentInRoot("kalanHesap1column");
		}
		return kalanHesap1column;
	}

	protected HtmlOutputText getKalanHesap1() {
		if (kalanHesap1 == null) {
			kalanHesap1 = (HtmlOutputText) findComponentInRoot("kalanHesap1");
		}
		return kalanHesap1;
	}

}