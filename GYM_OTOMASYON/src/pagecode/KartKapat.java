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
public class KartKapat extends PageCodeBase {

	protected HtmlScriptCollector scriptCollector1;
	protected HtmlOutputLinkEx linkEx1;
	protected HtmlOutputText text1;
	protected HtmlSelectOneMenu menu1;
	protected HtmlForm form1;
	protected HtmlOutputText text2;
	protected HtmlCommandExButton btnGetir;
	protected HtmlCommandExButton btnDeAktifEt;
	protected HtmlOutputText outtxtMessage;
	protected int kart_id;
	protected int uye_id;
	protected String adSoyad;
	protected List<KartlarBean> list_kartlar;
//Getir Butonu tetiklenince Comboboxtan seçilen nesnenin id 'si ne göre ad soyad getirir.
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
				mesaj = "Basari ile getirdi";
			}

		} catch (Exception e) {
			System.out.println("Adsoyad getirme exception :" + e.toString());
		} finally {
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
// Comboboxun için doldurur.
	public void kart_getir() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			list_kartlar = new ArrayList<KartlarBean>();
			conn = DBConnection.getConnection();
			String sql = "SELECT KART_ID , UYE_ID FROM GYM_KARTLAR GK  WHERE NOT EXISTS " + "(SELECT * FROM GYM_AKTIFLER GA WHERE GA.KART_ID = GK.KART_ID and GA.AKTIF = 0 ) ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				KartlarBean k = new KartlarBean();
				k.setKart_id(rs.getInt("KART_ID"));
				k.setUye_id(rs.getInt("UYE_ID"));
				list_kartlar.add(k);
			}
			if(list_kartlar.isEmpty() == true){
				mesaj = "Kartlar mevcut degil";
			}

		} catch (Exception e) {
			System.out.println("Liste kart getirme exception :" + e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	// comboboxdan seçilen değerin id'si ile tablo üzerinde işlem yapar
	public String doBtnDeAktifEtAction() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE GYM_AKTIFLER SET AKTIF = 0 WHERE KART_ID = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,kart_id);
			int rs = ps.executeUpdate();
			if (rs > 0) {
				System.out.println(kart_id + " Basari ile deaktif edildi");
				mesaj = "Basari ile aktif edildi";
			}
		} catch (Exception e) {
			System.out.println("Aktiflestirme exception " + e.toString());
		} finally {
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
	protected String mesaj;
	public List<KartlarBean> getList_kartlar() {
		kart_getir();
		return list_kartlar;
	}

	public void setList_kartlar(List<KartlarBean> list_kartlar) {
		this.list_kartlar = list_kartlar;
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

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
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

	protected HtmlSelectOneMenu getMenu1() {
		if (menu1 == null) {
			menu1 = (HtmlSelectOneMenu) findComponentInRoot("menu1");
		}
		return menu1;
	}

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}

	protected HtmlCommandExButton getBtnGetir() {
		if (btnGetir == null) {
			btnGetir = (HtmlCommandExButton) findComponentInRoot("btnGetir");
		}
		return btnGetir;
	}

	protected HtmlCommandExButton getBtnDeAktifEt() {
		if (btnDeAktifEt == null) {
			btnDeAktifEt = (HtmlCommandExButton) findComponentInRoot("btnDeAktifEt");
		}
		return btnDeAktifEt;
	}
	protected HtmlOutputText getOuttxtMessage() {
		if (outtxtMessage == null) {
			outtxtMessage = (HtmlOutputText) findComponentInRoot("outtxtMessage");
		}
		return outtxtMessage;
	}

}