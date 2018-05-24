/**
 * 
 */
package pagecode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;

import com.Beans.KartlarBean;
import com.DB.DBConnection;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.ibm.faces.component.html.HtmlOutputLinkEx;
import com.ibm.faces.component.html.HtmlScriptCollector;

/**
 * @author Mehmet
 * 
 */
public class KartOkut extends PageCodeBase {

	protected HtmlScriptCollector scriptCollector1;
	protected HtmlOutputLinkEx linkEx1;
	protected HtmlOutputText text1;
	protected HtmlOutputLinkEx linkEx2;
	protected HtmlOutputText text2;
	protected HtmlOutputLinkEx linkEx3;
	protected HtmlOutputText text3;
	protected HtmlOutputLinkEx linkEx4;
	protected HtmlOutputText text4;
	protected HtmlOutputLinkEx linkEx5;
	protected HtmlOutputText text5;
	protected HtmlSelectOneMenu cmbKartlar;
	protected HtmlForm form1;
	int kart_id;
	int uye_id;
	String adSoyad;
	String mesaj;
	List<KartlarBean> list_kartlar;
	protected HtmlCommandExButton btnGetir;
	protected HtmlOutputText outtxtAdSoyad;
	protected HtmlCommandExButton btnAktifEt;
	protected HtmlOutputText outtxtError;

	// Getir butonu tetiklendiginde comboboxdan secilen kartın hangi üyeye ait
	// oldugu bilgisi döner.
	public String doBtnGetirAction() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sqll = "SELECT KART_ID , GU.ADSOYAD FROM GYM_KARTLAR GK ," + " GYM_UYELER GU WHERE GK.KART_ID = ? and GK.UYE_ID = GU.UYE_ID";
			ps = conn.prepareStatement(sqll);
			ps.setInt(1, kart_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				adSoyad = rs.getString("ADSOYAD");
			}

		} catch (Exception e) {
			System.out.println("Adsoyad getirme exception :" + e.toString());
		}finally{
			try {
				conn.close();
				rs.close();
				ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return "";
	}

	// kart_getir metodunda aktifleştirilmemiş kartlar döner. Kartlar comboboxu
	// doldurulur.
	public void kart_getir() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			list_kartlar = new ArrayList<KartlarBean>();
			conn = DBConnection.getConnection();
			String sql = "SELECT GK.KART_ID ,GK.UYE_ID FROM GYM_AKTIFLER GA , GYM_KARTLAR GK WHERE GA.KART_ID = GK.KART_ID and GA.AKTIF = 0";
			ps = conn.prepareStatement(sql);
		    rs = ps.executeQuery();
			while (rs.next()) {
				KartlarBean k = new KartlarBean();
				k.setKart_id(rs.getInt("KART_ID"));
				k.setUye_id(rs.getInt("UYE_ID"));
				list_kartlar.add(k);
			}
			if(list_kartlar.isEmpty() == true) {
				mesaj = "Tum kartlar aktif.Liste bos";
			}
			else{
				mesaj = "Aktif olmayan kartlar basari ile yuklendi.";
			}

		} catch (Exception e) {
			System.out.println("Liste kart getirme exception :" + e.toString());
		}
		finally{
			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// Aktif Et butonu tetiklendiğinde comboboxdan seçilmiş olan kart_id
	// aktifler tablosuna insert edilir.
	public String doBtnAktifEtAction() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE  GYM_AKTIFLER SET AKTIF = ? WHERE KART_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, kart_id);
			int rs = ps.executeUpdate();
			if (rs > 0) {
				mesaj = kart_id +":" + " Basari ile aktif edildi";
			}
			else{
				mesaj = "Tum kartlar aktif";
			}
		} catch (Exception e) {
			System.out.println("Aktiflestirme exception " + e.toString());
		}
		finally{
			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
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
	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public int getKart_id() {
		return kart_id;
	}

	public void setKart_id(int kart_id) {
		this.kart_id = kart_id;
	}

	public int getUye_id() {
		return uye_id;
	}

	public void setUye_id(int uye_id) {
		this.uye_id = uye_id;
	}

	public List<KartlarBean> getList_kartlar() {
		kart_getir();
		return list_kartlar;
	}

	public void setList_kartlar(List<KartlarBean> list_kartlar) {
		this.list_kartlar = list_kartlar;
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

	protected HtmlSelectOneMenu getCmbKartlar() {
		if (cmbKartlar == null) {
			cmbKartlar = (HtmlSelectOneMenu) findComponentInRoot("cmbKartlar");
		}
		return cmbKartlar;
	}

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected HtmlCommandExButton getBtnGetir() {
		if (btnGetir == null) {
			btnGetir = (HtmlCommandExButton) findComponentInRoot("btnGetir");
		}
		return btnGetir;
	}

	protected HtmlOutputText getOuttxtAdSoyad() {
		if (outtxtAdSoyad == null) {
			outtxtAdSoyad = (HtmlOutputText) findComponentInRoot("outtxtAdSoyad");
		}
		return outtxtAdSoyad;
	}

	protected HtmlCommandExButton getBtnAktifEt() {
		if (btnAktifEt == null) {
			btnAktifEt = (HtmlCommandExButton) findComponentInRoot("btnAktifEt");
		}
		return btnAktifEt;
	}

	protected HtmlOutputText getOuttxtError() {
		if (outtxtError == null) {
			outtxtError = (HtmlOutputText) findComponentInRoot("outtxtError");
		}
		return outtxtError;
	}
}