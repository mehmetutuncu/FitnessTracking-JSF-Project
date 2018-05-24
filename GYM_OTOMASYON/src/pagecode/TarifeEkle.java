/**
 * 
 */
package pagecode;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;

import com.DB.DBConnection;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.ibm.faces.component.html.HtmlOutputLinkEx;
import com.ibm.faces.component.html.HtmlScriptCollector;

/**
 * @author Mehmet
 * 
 */
public class TarifeEkle extends PageCodeBase {

	protected HtmlScriptCollector scriptCollector1;
	protected HtmlOutputLinkEx linkEx1;
	protected HtmlOutputText text1;
	protected HtmlOutputLinkEx linkEx2;
	protected HtmlOutputText text2;
	protected HtmlOutputLinkEx linkEx3;
	protected HtmlOutputText text3;
	protected HtmlOutputLinkEx linkEx4;
	protected HtmlOutputText text4;
	protected HtmlOutputText outtxtTarife;
	protected HtmlInputText intxtTarifeAd;
	protected HtmlForm form1;
	protected HtmlOutputText outtxtTutar;
	protected HtmlInputText text6;
	protected HtmlCommandExButton btnKaydet;
	String tarife_fiyat;
	String tarife_ad;
	String errorMessage;
	Connection conn;
	PreparedStatement ps;
	// Kaydet butonu tetiklendiginde tarifeler tablosuna insert yapar.
	public String doBtnKaydetAction() {
		if (getTarife_ad().equals("") || getTarife_fiyat().equals("")) {
			errorMessage = "Tarife Adi ve fiyati bos birakilamaz.";
			return "";
		} else {
			int fiyat = Integer.parseInt(tarife_fiyat);
			if (fiyat > 0 || tarife_ad.length() > 3) {
				try {
					conn = DBConnection.getConnection();
					String sql = "INSERT INTO GYM_TARIFELER(TARIFEAD,FIYAT) VALUES(?,?)";
					ps = conn.prepareStatement(sql);
					ps.setString(1, tarife_ad);
					ps.setInt(2, fiyat);
					int result = ps.executeUpdate();
					if (result > 0) {
						tarife_ad = "";
						tarife_fiyat = "";
						errorMessage = "KAYIT BASARI ILE OLUSTURULDU.";
					}
				} catch (Exception e) {
					System.out.println("Exception ex" + e.toString());
				}
				finally{
					try {
						conn.close();
						ps.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			} else {
				errorMessage = "Tarife adi 3 karakterin ustu ve tarife fiyati 0 dan yuksek olmali.";
				return "";
			}
		}
		return "";
	}

	// TODO KOD AYRIMI
	public String getTarife_fiyat() {
		return tarife_fiyat;
	}

	public void setTarife_fiyat(String tarife_fiyat) {
		this.tarife_fiyat = tarife_fiyat;
	}

	public String getTarife_ad() {
		return tarife_ad;
	}

	public void setTarife_ad(String tarife_ad) {
		this.tarife_ad = tarife_ad;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	protected HtmlOutputText outtxtErrorMessage;
	protected HtmlOutputText text5;
	protected HtmlOutputLinkEx linkEx5;

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

	protected HtmlOutputText getOuttxtTarife() {
		if (outtxtTarife == null) {
			outtxtTarife = (HtmlOutputText) findComponentInRoot("outtxtTarife");
		}
		return outtxtTarife;
	}

	protected HtmlInputText getIntxtTarifeAd() {
		if (intxtTarifeAd == null) {
			intxtTarifeAd = (HtmlInputText) findComponentInRoot("intxtTarifeAd");
		}
		return intxtTarifeAd;
	}

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected HtmlOutputText getOuttxtTutar() {
		if (outtxtTutar == null) {
			outtxtTutar = (HtmlOutputText) findComponentInRoot("outtxtTutar");
		}
		return outtxtTutar;
	}

	protected HtmlInputText getText6() {
		if (text6 == null) {
			text6 = (HtmlInputText) findComponentInRoot("text6");
		}
		return text6;
	}

	protected HtmlCommandExButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = (HtmlCommandExButton) findComponentInRoot("btnKaydet");
		}
		return btnKaydet;
	}

	protected HtmlOutputText getOuttxtErrorMessage() {
		if (outtxtErrorMessage == null) {
			outtxtErrorMessage = (HtmlOutputText) findComponentInRoot("outtxtErrorMessage");
		}
		return outtxtErrorMessage;
	}

	protected HtmlOutputText getText5() {
		if (text5 == null) {
			text5 = (HtmlOutputText) findComponentInRoot("text5");
		}
		return text5;
	}

	protected HtmlOutputLinkEx getLinkEx5() {
		if (linkEx5 == null) {
			linkEx5 = (HtmlOutputLinkEx) findComponentInRoot("linkEx5");
		}
		return linkEx5;
	}

}