/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Frame;
import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.primefaces.context.RequestContext;

/**
 *
 * @author andresmalagueno
 */
public class Reportes implements Serializable{
     private EntityManagerFactory emf = null;
    private EntityManager em = null;
    
    public Connection getCon(){
    emf = Persistence.createEntityManagerFactory("MetalBlancoPU");
    em  = emf.createEntityManager();
    em.getTransaction().begin();
    java.sql.Connection cone = em.unwrap(java.sql.Connection.class);
    em.getTransaction().commit();
    return cone;
    }
    
    public String reporte(int numero){
        String url ="";

        try {

             Map parametro=new HashMap(); 
             parametro.put("numero",numero);
             String reports = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/reporte/Cotizacion.jrxml");
             JasperReport report = JasperCompileManager.compileReport(reports);
             JasperPrint print = JasperFillManager.fillReport(report,parametro,this.getCon());
     //        JasperExportManager.exportReportToHtmlFile(print,FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/reporte/Cotizacion.html"));
     //        JasperExportManager.exportReportToPdfFile(print,FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/reporte/Cotizacion.pdf"));
             HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                     response.addHeader("Content-disposition","attachment; filename=Cotizacion Nº"+numero+".pdf");
                     ServletOutputStream stream = response.getOutputStream();

                     JasperExportManager.exportReportToPdfStream(print, stream);
                     stream.flush();
                     stream.close();
                     FacesContext.getCurrentInstance().responseComplete();


     //       url ="../resources/reporte/Cotizacion.pdf";


             }
         catch (Exception e) {
           e.printStackTrace();
         }
              return url;

         }

    
    public String reporteNotas(int numero){
        String url ="";

        try {

             Map parametro=new HashMap(); 
             parametro.put("numero",numero);
             String reports = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/reporte/Notas.jrxml");
             JasperReport report = JasperCompileManager.compileReport(reports);
             JasperPrint print = JasperFillManager.fillReport(report,parametro,this.getCon());
     //        JasperExportManager.exportReportToHtmlFile(print,FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/reporte/Cotizacion.html"));
     //        JasperExportManager.exportReportToPdfFile(print,FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/reporte/Cotizacion.pdf"));
             HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                     response.addHeader("Content-disposition","attachment; filename=Nota de Venta Nº"+numero+".pdf");
                     ServletOutputStream stream = response.getOutputStream();

                     JasperExportManager.exportReportToPdfStream(print, stream);
                     stream.flush();
                     stream.close();
                     FacesContext.getCurrentInstance().responseComplete();


     //       url ="../resources/reporte/Cotizacion.pdf";


             }
         catch (Exception e) {
           e.printStackTrace();
         }
              return url;

         }
}
