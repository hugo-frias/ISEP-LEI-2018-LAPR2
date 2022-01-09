/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.GPSD;

import java.util.List;

import lapr.project.autorizacao.FacadeAuthorization;
import lapr.project.autorizacao.model.UserSession;

import lapr.project.gpsd.model.Company;

import lapr.project.utils.CompanyFinals;

/**
 *
 * @author paulomaio
 */
public class GPSD {

    private final Company company;
    private final FacadeAuthorization facadeAuthorization;

    private GPSD() {
        
        this.company = new Company(CompanyFinals.COMPANY_NAME, CompanyFinals.COMPANY_NIF);
        this.facadeAuthorization = this.company.getAuthorization();
        bootstrap();

    }

    public Company getCompany() {
        return this.company;
    }

    public UserSession getCurrentSession() {
        UserSession result = this.facadeAuthorization.getCurrentSession();
        if (result == null) {
            return null;
        }

        return result;
    }

    public boolean doLogin(String strId, String strPwd) {

        return this.facadeAuthorization.doLogin(strId, strPwd) != null;
    }

    public void doLogout() {
        this.facadeAuthorization.doLogout();
    }

    private void bootstrap() {
        this.facadeAuthorization.registerUserRole(CompanyFinals.ADMINISTRATIVE_ROLE);
        this.facadeAuthorization.registerUserRole(CompanyFinals.CLIENT_ROLE);
        this.facadeAuthorization.registerUserRole(CompanyFinals.HRO_ROLE);
        this.facadeAuthorization.registerUserRole(CompanyFinals.SERVICE_PROVIDER_ROLE);

        this.facadeAuthorization.registerUserWithRole("Administrative 1", "adm1@esoft.pt", CompanyFinals.OFFICER_PSWD, CompanyFinals.ADMINISTRATIVE_ROLE);
        this.facadeAuthorization.registerUserWithRole("Administrative 2", "adm2@esoft.pt", CompanyFinals.OFFICER_PSWD, CompanyFinals.ADMINISTRATIVE_ROLE);

        this.facadeAuthorization.registerUserWithRole("FRH 1", "hro1@esoft.pt", CompanyFinals.OFFICER_PSWD, CompanyFinals.HRO_ROLE);
        this.facadeAuthorization.registerUserWithRole("FRH 2", "hro2@esoft.pt", CompanyFinals.OFFICER_PSWD, CompanyFinals.HRO_ROLE);
       
    }
    // Inspirado em https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static GPSD singleton = null;

    public static GPSD getInstance() {
        if (singleton == null) {
            synchronized (GPSD.class) {
                singleton = new GPSD();
            }
        }
        return singleton;
    }

}
