package controler;

import java.sql.Connection;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.*;
import view.*;



public class Operations {
	

	public boolean crearCycle(cycle temp) {
		boolean inserto = false;
        Connection conn = null;
        Statement stmt = null;
		try {
            conn = connectionDB.connectioDB("sa", "1234");
            stmt = conn.createStatement();
            String sentencia = "insert into cycle(id_version, name_cyc, ctd_casos, ctd_exitos, ctd_defec, ctd_pend, porcent_exit, porcent_inc ) values(" + temp.getIdVersion() + ", '" + temp.getNameCycle()+ "', '" + temp.getCtdCasos()+ "', '" + temp.getCtdExito()+ "', '" + temp.getCtdDefec()+ "', '" + temp.getCtdPend()+ "', '" + temp.getPorExit()+ "', '" + temp.getPorInc()+ "');";
            stmt.execute(sentencia);
            inserto = true;
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
		return inserto;
	}



	//Llena el comboBox de las aplicaciones
	public void consultarTodosApp(JComboBox cbox_app) {
        Connection conn = null;
        Statement stmt = null;
        conn = connectionDB.connectioDB("sa", "1234");
        try {
            stmt = conn.createStatement();
            String consulta = "select * from application order by name_app";
            ResultSet resultado = stmt.executeQuery(consulta);
            cbox_app.addItem("Seleccione una opción");
            while(resultado.next()) {
            	cbox_app.addItem(resultado.getString("name_app"));
            	System.out.println(resultado.getString("name_app"));
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);

        }
	}
	
	public void consultarVersion(int id, JComboBox cbox_ver) {
		connectionDB conect  = new connectionDB();
        Connection conn = null;
        Statement stmt = null;
        conn = connectionDB.connectioDB("sa", "1234");
        try {
            stmt = conn.createStatement();
            String consulta = "select * from version where id_application = "+ id;
            ResultSet resultado = stmt.executeQuery(consulta);
            cbox_ver.addItem("Seleccione una versión");
            while(resultado.next()) {
            	cbox_ver.addItem(resultado.getString("name_ver"));
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);

        }
	}
	
	public int consultarIdApp(String name) {
		connectionDB conect  = new connectionDB();
        Connection conn = null;
        Statement stmt = null;
        int id = 0;
        conn = connectionDB.connectioDB("sa", "1234");
        try {
            stmt = conn.createStatement();
            String consulta = "select id_application from application where name_app = '"+ name +"';";
            ResultSet resultado = stmt.executeQuery(consulta);
            	while(resultado.next()) {
            		id = resultado.getInt("id_application");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return id;

	}
	
	public int consultarIdVer(String name, int id_app) {
		connectionDB conect  = new connectionDB();
        Connection conn = null;
        Statement stmt = null;
        int id = 0;
        conn = connectionDB.connectioDB("sa", "1234");
        try {
            stmt = conn.createStatement();
            String consulta = "select id_version from version where name_ver = '"+ name +"' and id_application = '"+ id_app +"';";
            ResultSet resultado = stmt.executeQuery(consulta);
            	while(resultado.next()) {
            		id = resultado.getInt("id_version");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return id;

	}

}
