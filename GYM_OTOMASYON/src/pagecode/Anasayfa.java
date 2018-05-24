/**
 * 
 */
package pagecode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.faces.component.html.HtmlOutputText;

import com.DB.DBConnection;
import com.ibm.faces.component.html.HtmlGraphicImageEx;
import com.ibm.faces.component.html.HtmlOutputLinkEx;
import com.ibm.faces.component.html.HtmlScriptCollector;

/**
 * @author Mehmet
 * 
 */
public class Anasayfa extends PageCodeBase {

	protected HtmlOutputLinkEx linkEx1;
	protected HtmlScriptCollector scriptCollector1;
	protected HtmlOutputText text1;
	protected HtmlOutputLinkEx linkEx2;
	protected HtmlOutputText text2;
	protected HtmlOutputLinkEx linkEx5;
	protected HtmlOutputText text5;
	protected HtmlOutputLinkEx linkEx6;
	protected HtmlOutputText text6;
	protected HtmlOutputLinkEx linkEx7;
	protected HtmlOutputText text7;
	protected HtmlOutputLinkEx linkEx3;
	protected HtmlOutputText text3;
	protected HtmlOutputLinkEx linkEx4;
	protected HtmlOutputText text4;
	protected HtmlGraphicImageEx imageEx1;
	protected HtmlOutputText text8;
	protected HtmlOutputText text9;
	int kazanc;
	public int getKazanc() 
	{	hesap();
		return kazanc;
	}
	public void setKazanc(int kazanc) {
		this.kazanc = kazanc;
	}
	public void hesap(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT GT.FIYAT , GKT.AY FROM GYM_KULLANICITARIFELER GKT , GYM_TARIFELER GT WHERE GKT.TARIFE_ID = GT.TARIFE_ID ";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int ay = rs.getInt("AY");
				int fiyat = rs.getInt("FIYAT");
				kazanc += (ay*fiyat);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	protected HtmlOutputLinkEx getLinkEx1() {
		if (linkEx1 == null) {
			linkEx1 = (HtmlOutputLinkEx) findComponentInRoot("linkEx1");
		}
		return linkEx1;
	}

	protected HtmlScriptCollector getScriptCollector1() {
		if (scriptCollector1 == null) {
			scriptCollector1 = (HtmlScriptCollector) findComponentInRoot("scriptCollector1");
		}
		return scriptCollector1;
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

	protected HtmlOutputLinkEx getLinkEx6() {
		if (linkEx6 == null) {
			linkEx6 = (HtmlOutputLinkEx) findComponentInRoot("linkEx6");
		}
		return linkEx6;
	}

	protected HtmlOutputText getText6() {
		if (text6 == null) {
			text6 = (HtmlOutputText) findComponentInRoot("text6");
		}
		return text6;
	}

	protected HtmlOutputLinkEx getLinkEx7() {
		if (linkEx7 == null) {
			linkEx7 = (HtmlOutputLinkEx) findComponentInRoot("linkEx7");
		}
		return linkEx7;
	}

	protected HtmlOutputText getText7() {
		if (text7 == null) {
			text7 = (HtmlOutputText) findComponentInRoot("text7");
		}
		return text7;
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

	protected HtmlGraphicImageEx getImageEx1() {
		if (imageEx1 == null) {
			imageEx1 = (HtmlGraphicImageEx) findComponentInRoot("imageEx1");
		}
		return imageEx1;
	}
	protected HtmlOutputText getText8() {
		if (text8 == null) {
			text8 = (HtmlOutputText) findComponentInRoot("text8");
		}
		return text8;
	}
	protected HtmlOutputText getText9() {
		if (text9 == null) {
			text9 = (HtmlOutputText) findComponentInRoot("text9");
		}
		return text9;
	}

}