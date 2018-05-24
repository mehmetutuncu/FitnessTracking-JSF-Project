package com.BeanUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Beans.KullaniciBean;
import com.DB.DBConnection;

public class KullaniciManager {

	// ArrayList tipinde icine kullanıcıBean alabilen fonksiyon.
	// Bu fonksiyon arraylist'i newler ve icine sorgu ile döndürdüğü
	// parametreleri atar.
	public ArrayList<KullaniciBean> getKullaniciListesi() throws SQLException {
		ArrayList<KullaniciBean> kullaniciList = new ArrayList<KullaniciBean>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT  GU.UYE_ID ,GK.KART_ID, GU.ADSOYAD, GU.YAS from  GYM_KARTLAR GK, GYM_UYELER GU where GU.UYE_ID = GK.UYE_ID and GU.DURUM = 0 order by  GU.ADSOYAD";

		System.out.println("sql : " + sql);
		con = DBConnection.getConnection();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				KullaniciBean kb = new KullaniciBean();
				kb.setUye_id(rs.getInt("UYE_ID"));
				kb.setKartId(rs.getInt("KART_ID"));
				kb.setAdSoyad(rs.getString("ADSOYAD"));
				kb.setYas(rs.getInt("YAS"));

				kullaniciList.add(kb);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			ps.close();
			con.close();
		}
		return kullaniciList;
	}

	// TODO KOD AYRIMI
}
