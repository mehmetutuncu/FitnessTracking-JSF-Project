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
import java.util.Map;

import javax.faces.component.UISelectItem;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.component.html.HtmlSelectOneRadio;

import com.Beans.TarifeBean;
import com.DB.DBConnection;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.ibm.faces.component.html.HtmlOutputLinkEx;
import com.ibm.faces.component.html.HtmlScriptCollector;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * @author Mehmet
 * 
 */
public class UyeTarife extends PageCodeBase {
	protected HtmlScriptCollector scriptCollector1;
	protected HtmlForm form1;
	int tarife_id;
	String tarife_ad;
	int uye_id;
	String adSoyad;
	int deger = 1;

	List<TarifeBean> list_tarifeler;

	protected HtmlCommandExButton btnEkle;
	protected HtmlOutputLinkEx linkEx1;
	protected HtmlOutputText text1;
	protected HtmlSelectOneMenu menu1;
	protected HtmlSelectOneRadio radio1;
	protected UISelectItem selectItem1;
	protected UISelectItem selectItem2;
	protected UISelectItem selectItem3;
	protected UISelectItem selectItem4;

	public void islem() {
		list_tarifeler = new ArrayList<TarifeBean>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println("UYE ID : " + uye_id);
		String sql = "SELECT GT.TARIFE_ID ,GT.TARIFEAD FROM GYM_TARIFELER  GT WHERE NOT EXISTS (SELECT * FROM GYM_KULLANICITARIFELER  GKT WHERE GKT.TARIFE_ID = GT.TARIFE_ID and UYE_ID = ?)";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uye_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				TarifeBean tb = new TarifeBean();
				tb.setTarife_id(rs.getInt("TARIFE_ID"));
				tb.setTarife_ad(rs.getString("TARIFEAD"));

				list_tarifeler.add(tb);
			}
			if (tarife_id == 0 && list_tarifeler.size() > 0) {
				tarife_id = list_tarifeler.get(0).getTarife_id();
			}

			System.out.println(uye_id);
		} catch (Exception e) {
			System.out.println("Exception :" + e.toString());
			e.printStackTrace();
		}

	}

	public String doBtnEkleAction() {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		
		final SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		String basTarihi = df.format(new Date());
		System.out.println("Radio: "+ deger);
		String sql = "INSERT INTO GYM_KULLANICITARIFELER(UYE_ID,TARIFE_ID,AY,BASTARIHI) VALUES(?,?,?,?)";
		if (uye_id != 0 && tarife_id != 0) {
			try {
				conn = DBConnection.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setInt(1, uye_id);
				ps.setInt(2, tarife_id);
				ps.setInt(3, deger);
				ps.setString(4, basTarihi);
				result = ps.executeUpdate();
				if (result > 0) {
					System.out.println("Ekleme Basarili");
				}
			} catch (Exception e) {
				System.out.println("INSERT EXCEPTION :" + e.toString());
				e.printStackTrace();
			} finally {
				try {

				} catch (Exception e2) {
				}
			}

		} else {
			return "Anasayfa.jsp";
		}
		return "";
	}

	// TODO KOD AYRIMI
	public int getDeger() {
		return deger;
	}

	public void setDeger(int deger) {
		this.deger = deger;
	}

	public int getTarife_id() {
		return tarife_id;
	}

	public void setTarife_id(int tarife_id) {
		this.tarife_id = tarife_id;
	}

	public String getTarife_ad() {
		return tarife_ad;
	}

	public void setTarife_ad(String tarife_ad) {
		this.tarife_ad = tarife_ad;
	}

	public List<TarifeBean> getList_tarifeler() {
			islem();	
		return list_tarifeler;
	}

	public int getUye_id() {
		@SuppressWarnings("unchecked")
		Map<String, String> param = getRequestParam();
		String degisken = (String) param.get("uye_id");
		System.out.println("Degisken :" + degisken);
		if (degisken != null) {
			uye_id = Integer.parseInt(degisken);
		}

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

	public void setList_tarifeler(List<TarifeBean> list_tarifeler) {
		this.list_tarifeler = list_tarifeler;
	}

	protected HtmlScriptCollector getScriptCollector1() {
		if (scriptCollector1 == null) {
			scriptCollector1 = (HtmlScriptCollector) findComponentInRoot("scriptCollector1");
		}
		return scriptCollector1;
	}

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected HtmlCommandExButton getBtnEkle() {
		if (btnEkle == null) {
			btnEkle = (HtmlCommandExButton) findComponentInRoot("btnEkle");
		}
		return btnEkle;
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

	protected HtmlSelectOneRadio getRadio1() {
		if (radio1 == null) {
			radio1 = (HtmlSelectOneRadio) findComponentInRoot("radio1");
		}
		return radio1;
	}

	protected UISelectItem getSelectItem1() {
		if (selectItem1 == null) {
			selectItem1 = (UISelectItem) findComponentInRoot("selectItem1");
		}
		return selectItem1;
	}

	protected UISelectItem getSelectItem2() {
		if (selectItem2 == null) {
			selectItem2 = (UISelectItem) findComponentInRoot("selectItem2");
		}
		return selectItem2;
	}

	protected UISelectItem getSelectItem3() {
		if (selectItem3 == null) {
			selectItem3 = (UISelectItem) findComponentInRoot("selectItem3");
		}
		return selectItem3;
	}

	protected UISelectItem getSelectItem4() {
		if (selectItem4 == null) {
			selectItem4 = (UISelectItem) findComponentInRoot("selectItem4");
		}
		return selectItem4;
	}

}