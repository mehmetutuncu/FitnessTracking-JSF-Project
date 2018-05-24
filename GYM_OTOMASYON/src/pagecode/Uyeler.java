/**
 * 
 */
package pagecode;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlOutputText;

import com.BeanUtil.KullaniciManager;
import com.Beans.KullaniciBean;
import com.ibm.faces.component.UIColumnEx;
import com.ibm.faces.component.html.HtmlDataTableEx;
import com.ibm.faces.component.html.HtmlOutputLinkEx;
import com.ibm.faces.component.html.HtmlRequestLink;
import com.ibm.faces.component.html.HtmlScriptCollector;

/**
 * @author Mehmet
 *
 */
public class Uyeler extends PageCodeBase {
	protected ArrayList<KullaniciBean> kullaniciBeanList;
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
	protected HtmlOutputText text6;
	protected HtmlOutputText text7;
	protected HtmlOutputText text8;
	protected HtmlOutputText text9;
	protected HtmlOutputText text10;
	protected HtmlOutputText text11;
	protected HtmlForm form1;
	protected HtmlDataTableEx kullaniciBeanList1;
	protected HtmlOutputText yas1text;
	protected HtmlOutputText kartId1text;
	protected HtmlOutputText adSoyad1text;
	protected UIColumnEx yas1column;
	protected HtmlOutputText yas1;
	protected UIColumnEx kartId1column;
	protected HtmlOutputText kartId1;
	protected UIColumnEx adSoyad1column;
	protected HtmlRequestLink link1;
	protected UIParameter param1;
	public boolean getUyariGoster(){
		return true; // util in içine kontrol metodu;;
	}
	
	//ArrayList tipinde içine KullanıcıBean alabilen bir fonksiyon.
	//Liste doldurmak icin kullanılır
	
	@SuppressWarnings("unchecked")
	public ArrayList<KullaniciBean> getKullaniciBeanList() throws SQLException {
		if ( kullaniciBeanList == null ) {
			kullaniciBeanList = new ArrayList<KullaniciBean>();
			KullaniciManager manager = new KullaniciManager();
			kullaniciBeanList = manager.getKullaniciListesi();
			getSessionScope().put("kullaniciBean_SS", kullaniciBeanList);
		}
		
		return (ArrayList<KullaniciBean>) getSessionScope().get("kullaniciBean_SS");
	}

//TODO KOD AYRIMI
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

	protected HtmlOutputText getText6() {
		if (text6 == null) {
			text6 = (HtmlOutputText) findComponentInRoot("text6");
		}
		return text6;
	}

	protected HtmlOutputText getText7() {
		if (text7 == null) {
			text7 = (HtmlOutputText) findComponentInRoot("text7");
		}
		return text7;
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

	protected HtmlOutputText getText10() {
		if (text10 == null) {
			text10 = (HtmlOutputText) findComponentInRoot("text10");
		}
		return text10;
	}

	protected HtmlOutputText getText11() {
		if (text11 == null) {
			text11 = (HtmlOutputText) findComponentInRoot("text11");
		}
		return text11;
	}


	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected HtmlDataTableEx getKullaniciBeanList1() {
		if (kullaniciBeanList1 == null) {
			kullaniciBeanList1 = (HtmlDataTableEx) findComponentInRoot("kullaniciBeanList1");
		}
		return kullaniciBeanList1;
	}

	protected HtmlOutputText getYas1text() {
		if (yas1text == null) {
			yas1text = (HtmlOutputText) findComponentInRoot("yas1text");
		}
		return yas1text;
	}

	protected HtmlOutputText getKartId1text() {
		if (kartId1text == null) {
			kartId1text = (HtmlOutputText) findComponentInRoot("kartId1text");
		}
		return kartId1text;
	}

	protected HtmlOutputText getAdSoyad1text() {
		if (adSoyad1text == null) {
			adSoyad1text = (HtmlOutputText) findComponentInRoot("adSoyad1text");
		}
		return adSoyad1text;
	}

	protected UIColumnEx getYas1column() {
		if (yas1column == null) {
			yas1column = (UIColumnEx) findComponentInRoot("yas1column");
		}
		return yas1column;
	}

	protected HtmlOutputText getYas1() {
		if (yas1 == null) {
			yas1 = (HtmlOutputText) findComponentInRoot("yas1");
		}
		return yas1;
	}

	protected UIColumnEx getKartId1column() {
		if (kartId1column == null) {
			kartId1column = (UIColumnEx) findComponentInRoot("kartId1column");
		}
		return kartId1column;
	}

	protected HtmlOutputText getKartId1() {
		if (kartId1 == null) {
			kartId1 = (HtmlOutputText) findComponentInRoot("kartId1");
		}
		return kartId1;
	}

	protected UIColumnEx getAdSoyad1column() {
		if (adSoyad1column == null) {
			adSoyad1column = (UIColumnEx) findComponentInRoot("adSoyad1column");
		}
		return adSoyad1column;
	}

	protected HtmlRequestLink getLink1() {
		if (link1 == null) {
			link1 = (HtmlRequestLink) findComponentInRoot("link1");
		}
		return link1;
	}

	protected UIParameter getParam1() {
		if (param1 == null) {
			param1 = (UIParameter) findComponentInRoot("param1");
		}
		return param1;
	}

	public String ekle() {
	
	
		return "UyeTarife.jsp";
	}

}