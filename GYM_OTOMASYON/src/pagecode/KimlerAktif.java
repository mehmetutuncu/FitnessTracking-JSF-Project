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

import com.Beans.AktiflerBean;
import com.DB.DBConnection;
import com.ibm.faces.component.UIColumnEx;
import com.ibm.faces.component.html.HtmlDataTableEx;
import com.ibm.faces.component.html.HtmlOutputLinkEx;
import com.ibm.faces.component.html.HtmlScriptCollector;

/**
 * @author Mehmet
 * 
 */
public class KimlerAktif extends PageCodeBase {

	protected HtmlScriptCollector scriptCollector1;
	protected HtmlOutputLinkEx linkEx1;
	protected HtmlOutputText text1;
	protected HtmlOutputLinkEx linkEx2;
	protected HtmlOutputLinkEx linkEx3;
	protected HtmlOutputText text3;
	protected HtmlOutputLinkEx linkEx4;
	protected HtmlOutputText text4;
	protected HtmlOutputLinkEx linkEx5;
	protected HtmlOutputText text5;
	protected HtmlOutputText text2;
	protected HtmlForm form1;
	protected HtmlOutputText adSoyad1;
	protected HtmlDataTableEx list_aktifler2;
	protected HtmlDataTableEx list_aktifler1;
	protected UIColumnEx kart_id1column;
	protected HtmlOutputText kart_id1text;
	protected HtmlOutputText kart_id1;
	protected UIColumnEx adSoyad1column;
	protected HtmlDataTableEx list_aktifler3;
	protected UIColumnEx yas1column;
	protected HtmlOutputText yas1text;
	protected HtmlOutputText yas1;
	protected HtmlOutputText adSoyad1text;
	int kart_id;
	int yas;
	String adSoyad;
	List<AktiflerBean> list_aktifler;
	String mesaj ;
	protected HtmlOutputText outtxtMessage;
		// liste_doldur metodunda aktif olan kisiye ait bilgiler döner.
	public void liste_doldur() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			list_aktifler = new ArrayList<AktiflerBean>();
			conn = DBConnection.getConnection();
			String sql = "SELECT GK.KART_ID,GU.ADSOYAD,GU.YAS FROM GYM_AKTIFLER  GA,GYM_UYELER GU,GYM_KARTLAR GK " + "WHERE GA.AKTIF = ? and GA.KART_ID = GK.KART_ID and GK.UYE_ID = GU.UYE_ID";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			rs = ps.executeQuery();
			while (rs.next()) {
				AktiflerBean ab = new AktiflerBean();
				ab.setKart_id(rs.getInt("KART_ID"));
				ab.setAdSoyad(rs.getString("ADSOYAD"));
				ab.setYas(rs.getInt("YAS"));
				list_aktifler.add(ab);
			}
			if(list_aktifler.isEmpty() == true){
				mesaj = "Aktif kullanici bulunmamaktadir.";
			}
			else{
				mesaj = "Aktif kullanicilar basari ile yuklendi.";
			}
		} catch (Exception e) {
			System.out.println("");
		}finally{
			try {
				conn.close();
				ps.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// TODO KOD AYRIMI
	
	public List<AktiflerBean> getList_aktifler() {
		liste_doldur();
		return list_aktifler;
	}

	public String getMesaj() {
		return mesaj;
	}

	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}

	public void setList_aktifler(List<AktiflerBean> list_aktifler) {
		this.list_aktifler = list_aktifler;
	}

	public int getKart_id() {

		return kart_id;
	}

	public void setKart_id(int kart_id) {
		this.kart_id = kart_id;
	}

	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
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

	protected HtmlOutputLinkEx getLinkEx2() {
		if (linkEx2 == null) {
			linkEx2 = (HtmlOutputLinkEx) findComponentInRoot("linkEx2");
		}
		return linkEx2;
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

	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected HtmlOutputText getAdSoyad1() {
		if (adSoyad1 == null) {
			adSoyad1 = (HtmlOutputText) findComponentInRoot("adSoyad1");
		}
		return adSoyad1;
	}

	protected HtmlDataTableEx getList_aktifler2() {
		if (list_aktifler2 == null) {
			list_aktifler2 = (HtmlDataTableEx) findComponentInRoot("list_aktifler2");
		}
		return list_aktifler2;
	}

	protected HtmlDataTableEx getList_aktifler1() {
		if (list_aktifler1 == null) {
			list_aktifler1 = (HtmlDataTableEx) findComponentInRoot("list_aktifler1");
		}
		return list_aktifler1;
	}

	protected UIColumnEx getKart_id1column() {
		if (kart_id1column == null) {
			kart_id1column = (UIColumnEx) findComponentInRoot("kart_id1column");
		}
		return kart_id1column;
	}

	protected HtmlOutputText getKart_id1text() {
		if (kart_id1text == null) {
			kart_id1text = (HtmlOutputText) findComponentInRoot("kart_id1text");
		}
		return kart_id1text;
	}

	protected HtmlOutputText getKart_id1() {
		if (kart_id1 == null) {
			kart_id1 = (HtmlOutputText) findComponentInRoot("kart_id1");
		}
		return kart_id1;
	}

	protected UIColumnEx getAdSoyad1column() {
		if (adSoyad1column == null) {
			adSoyad1column = (UIColumnEx) findComponentInRoot("adSoyad1column");
		}
		return adSoyad1column;
	}

	protected HtmlDataTableEx getList_aktifler3() {
		if (list_aktifler3 == null) {
			list_aktifler3 = (HtmlDataTableEx) findComponentInRoot("list_aktifler3");
		}
		return list_aktifler3;
	}

	protected UIColumnEx getYas1column() {
		if (yas1column == null) {
			yas1column = (UIColumnEx) findComponentInRoot("yas1column");
		}
		return yas1column;
	}

	protected HtmlOutputText getYas1text() {
		if (yas1text == null) {
			yas1text = (HtmlOutputText) findComponentInRoot("yas1text");
		}
		return yas1text;
	}

	protected HtmlOutputText getYas1() {
		if (yas1 == null) {
			yas1 = (HtmlOutputText) findComponentInRoot("yas1");
		}
		return yas1;
	}

	protected HtmlOutputText getAdSoyad1text() {
		if (adSoyad1text == null) {
			adSoyad1text = (HtmlOutputText) findComponentInRoot("adSoyad1text");
		}
		return adSoyad1text;
	}

	protected HtmlOutputText getOuttxtMessage() {
		if (outtxtMessage == null) {
			outtxtMessage = (HtmlOutputText) findComponentInRoot("outtxtMessage");
		}
		return outtxtMessage;
	}

}