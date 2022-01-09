/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.List;
import lapr.project.gpsd.GPSD.GPSD;
import lapr.project.gpsd.controller.IndicateAvailabilityController;
import lapr.project.gpsd.controller.MakeServiceRequestController;
import lapr.project.gpsd.controller.RateServiceController;
import lapr.project.gpsd.controller.RegisterClientController;
import lapr.project.gpsd.controller.RegisterServiceProviderController;
import lapr.project.gpsd.controller.ReportEndOfServiceController;
import lapr.project.gpsd.model.Affectation;
import lapr.project.gpsd.model.Application;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.ExpandableService;
import lapr.project.gpsd.model.FixedService;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.model.LimitedService;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.Rate;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceRequest;
import lapr.project.gpsd.model.ServiceType;
import lapr.project.gpsd.model.ZipCode;
import lapr.project.utils.Date;
import lapr.project.utils.Time;

/**
 *
 * @author Beatriz Ribeiro
 */
public class InitApp {

    public static void Init() {

        ServiceType st1 = GPSD.getInstance().getCompany().getServiceTypesRegistry().getServiceTypes().get(0);
        ServiceType st2 = GPSD.getInstance().getCompany().getServiceTypesRegistry().getServiceTypes().get(1);
        ServiceType st3 = GPSD.getInstance().getCompany().getServiceTypesRegistry().getServiceTypes().get(2);

        //Init Categories
        Category cat1 = new Category("1", "Plumber");
        Category cat2 = new Category("2", "Locksmith");
        Category cat3 = new Category("3", "Automotive Mechanic");
        Category cat4 = new Category("4", "Cook");
        Category cat5 = new Category("5", "Painter");
        GPSD.getInstance().getCompany().getCategoriesRegistry().addCategory(cat1);
        GPSD.getInstance().getCompany().getCategoriesRegistry().addCategory(cat2);
        GPSD.getInstance().getCompany().getCategoriesRegistry().addCategory(cat3);
        GPSD.getInstance().getCompany().getCategoriesRegistry().addCategory(cat4);
        GPSD.getInstance().getCompany().getCategoriesRegistry().addCategory(cat5);

        //Init Services
        FixedService serv1 = new FixedService("1", "Light Plumbing", "Install water tap", 100.0, cat1, st1);
        serv1.setAdditionalData(60);
        LimitedService serv2 = new LimitedService("2", "Heavy Plumbing", "Pipeline Repair", 40.0, cat1, st2);
        LimitedService serv3 = new LimitedService("3", "Gate Painting", "Gate Painting", 60.0, cat5, st2);
        ExpandableService serv4 = new ExpandableService("4", "Prepare dinner", "Prepare dinner and clean kitchen", 80.0, cat4, st3);
        LimitedService serv5 = new LimitedService("5", "Repair vehicle", "Repair vehicle engine", 80.0, cat3, st2);
        FixedService serv6 = new FixedService("6", "Gate Painting", "Gate Painting", 90.0, cat5, st1);
        serv6.setAdditionalData(60);
        GPSD.getInstance().getCompany().getServicesRegistry().getServices().add(serv1);
        GPSD.getInstance().getCompany().getServicesRegistry().getServices().add(serv2);
        GPSD.getInstance().getCompany().getServicesRegistry().getServices().add(serv3);
        GPSD.getInstance().getCompany().getServicesRegistry().getServices().add(serv4);
        GPSD.getInstance().getCompany().getServicesRegistry().getServices().add(serv5);
        GPSD.getInstance().getCompany().getServicesRegistry().getServices().add(serv6);

        //Init Geographival Areas
        GeographicalArea ga1 = new GeographicalArea("Gondomar-1", 50.0, 30000, "4420-002");
        GeographicalArea ga2 = new GeographicalArea("Gondomar-2", 10.0, 5000, "4420-570");
        GeographicalArea ga3 = new GeographicalArea("Gondomar-3", 20.0, 8000, "4435-685");
        GeographicalArea ga4 = new GeographicalArea("Porto-1", 30.0, 20000, "4250-108");
        GeographicalArea ga5 = new GeographicalArea("Maia-1", 40.0, 20000, "4470-526");
        GPSD.getInstance().getCompany().getGeographicalAreaResgitry().getGeographicalAreas().add(ga1);
        GPSD.getInstance().getCompany().getGeographicalAreaResgitry().getGeographicalAreas().add(ga2);
        GPSD.getInstance().getCompany().getGeographicalAreaResgitry().getGeographicalAreas().add(ga3);
        GPSD.getInstance().getCompany().getGeographicalAreaResgitry().getGeographicalAreas().add(ga4);
        GPSD.getInstance().getCompany().getGeographicalAreaResgitry().getGeographicalAreas().add(ga5);

        //Init Clients
        RegisterClientController rcc = new RegisterClientController();
        rcc.newClient("Maria Santos", 100542369, 936565651, "msantos@gmail.com", "prosdbsts190", "Rua D. João de França, nº1", "4420-001", "Gondomar");
        rcc.registerClient();
        rcc.newClient("António Lage", 20054266, 916535661, "aLage@gmail.com", "aLage1234", "R. Gonçalves de Castro, nº 8", "4415-999", "Pedroso");
        rcc.registerClient();
        rcc.newClient("Ana Santos", 110542349, 966535661, "aSantos23@isep.ipp.pt", "aSantini456", "R. do Carvalhido, nº 9", "4250-100", "Porto");
        rcc.registerClient();
        rcc.newClient("Joana Santos", 210975020, 966545644, "jSantos@isep.ipp.pt", "jjSantos23", "R. Cegonheira, nº 3", "4470-528", "Maia");
        rcc.registerClient();

        //Init ServiceProviders
        RegisterServiceProviderController rsoc = new RegisterServiceProviderController();
        rsoc.newServiceProvider("António Dos Santos Padrão", "Rua X", "4415-995", "Porto");
        rsoc.setAditionalData("10001", "aPadrao@gmail.com");
        rsoc.setCategory(cat3);
        rsoc.setCategory(cat1);
        rsoc.setGeographicalArea(ga1);
        rsoc.setGeographicalArea(ga2);
        rsoc.registServiceProvider();
        rsoc.newServiceProvider("Maria Das Neves Silva", "Rua Y", "4420-002", "Porto");
        rsoc.setAditionalData("10002", "mSilva@hotmail.com");
        rsoc.setCategory(cat2);
        rsoc.setCategory(cat4);
        rsoc.setCategory(cat5);
        rsoc.setGeographicalArea(ga4);
        rsoc.registServiceProvider();
        rsoc.newServiceProvider("Joaquina Dos Santos", "Rua Z", "4470-526", "Porto");
        rsoc.setAditionalData("10003", "jaquina@hotmail.com");
        rsoc.setCategory(cat1);
        rsoc.setCategory(cat2);
        rsoc.setCategory(cat3);
        rsoc.setGeographicalArea(ga5);
        rsoc.registServiceProvider();
        rsoc.newServiceProvider("Serafim Santos", "Rua W", "4430-601", "Porto");
        rsoc.setAditionalData("10004", "sSantos@gmail.com");
        rsoc.setCategory(cat1);
        rsoc.setCategory(cat5);
        rsoc.setGeographicalArea(ga2);
        rsoc.setGeographicalArea(ga5);
        rsoc.registServiceProvider();

        //Init ServiceRequests
        MakeServiceRequestController msrc = new MakeServiceRequestController();
        //ServiceRequest 1
        GPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        List<PostalAddress> pal = msrc.newServiceRequest();
        msrc.setEndPostal(pal.get(0));
        msrc.addToServiceRequest(serv1, "Close water tap", serv1.getOtherAttributes());
        try {
            msrc.addSchedule(new Date(2019, 6, 3), new Time(9, 00));
        } catch (IllegalArgumentException e) {

        }
        try {
            msrc.addSchedule(new Date(2019, 6, 5), new Time(22, 00));
        } catch (IllegalArgumentException e) {

        }
        msrc.computesCost();
        msrc.registsServicerequest();
        GPSD.getInstance().getCurrentSession().doLogout();

        //Service Request 2
        GPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        List<PostalAddress> pal2 = msrc.newServiceRequest();
        msrc.setEndPostal(pal2.get(0));
        msrc.addToServiceRequest(serv2, "Pipeline repair", 60);
        try {
            msrc.addSchedule(new Date(2019, 6, 23), new Time(9, 00));
        } catch (IllegalArgumentException e) {
        }
        try {
            msrc.addSchedule(new Date(2019, 6, 25), new Time(22, 00));
        } catch (IllegalArgumentException e) {

        }
        msrc.computesCost();
        msrc.registsServicerequest();
        GPSD.getInstance().getCurrentSession().doLogout();

        //Service Request 3
        GPSD.getInstance().doLogin("aSantos23@isep.ipp.pt", "aSantini456");
        List<PostalAddress> pal3 = msrc.newServiceRequest();
        msrc.setEndPostal(pal3.get(0));
        msrc.addToServiceRequest(serv3, "Iron Gate Painting", 120);
        try {
            msrc.addSchedule(new Date(2019, 6, 25), new Time(10, 00));
        }catch(IllegalArgumentException e){
           
        }try{
             msrc.addSchedule(new Date(2019, 6, 25), new Time(14, 30));
        } catch (IllegalArgumentException e) {

        }
        msrc.computesCost();
        msrc.registsServicerequest();
        GPSD.getInstance().getCurrentSession().doLogout();

        //Service Request 4
        GPSD.getInstance().doLogin("aSantos23@isep.ipp.pt", "aSantini456");
        List<PostalAddress> pal4 = msrc.newServiceRequest();
        msrc.setEndPostal(pal4.get(0));
        msrc.addToServiceRequest(serv4, "Prepare Dinner and clean Kitchen", 120);
        try {
            msrc.addSchedule(new Date(2019, 6, 6), new Time(19, 00));
        } catch (IllegalArgumentException e) {

        }
        msrc.computesCost();
        msrc.registsServicerequest();
        GPSD.getInstance().getCurrentSession().doLogout();

        //Service request 5
        GPSD.getInstance().doLogin("jSantos@isep.ipp.pt", "jjSantos23");
        List<PostalAddress> pal5 = msrc.newServiceRequest();
        msrc.setEndPostal(pal5.get(0));
        msrc.addToServiceRequest(serv1, "Water tap repair", serv1.getOtherAttributes());
        try {
            msrc.addSchedule(new Date(2019, 6, 7), new Time(19, 00));
        } catch (IllegalArgumentException e) {

        }
        msrc.computesCost();
        msrc.registsServicerequest();
        GPSD.getInstance().getCurrentSession().doLogout();

        //Service request 6
        GPSD.getInstance().doLogin("jSantos@isep.ipp.pt", "jjSantos23");
        List<PostalAddress> pal6 = msrc.newServiceRequest();
        msrc.setEndPostal(pal6.get(0));
        msrc.addToServiceRequest(serv5, "Repair vehicle and change oil ", 60);
        try {
            msrc.addSchedule(new Date(2019, 6, 8), new Time(9, 00));
        } catch (IllegalArgumentException e) {

        }
        msrc.computesCost();
        msrc.registsServicerequest();
        GPSD.getInstance().getCurrentSession().doLogout();

        //Service request 7
        GPSD.getInstance().doLogin("jSantos@isep.ipp.pt", "jjSantos23");
        List<PostalAddress> pal7 = msrc.newServiceRequest();
        msrc.setEndPostal(pal7.get(0));
        msrc.addToServiceRequest(serv6, "Gate Painting", serv6.getOtherAttributes());
        try {
            msrc.addSchedule(new Date(2019, 6, 29), new Time(20, 00));
        } catch (IllegalArgumentException e) {

        }
        msrc.computesCost();
        msrc.registsServicerequest();
        GPSD.getInstance().getCurrentSession().doLogout();

        //Availabilities
        IndicateAvailabilityController iac = new IndicateAvailabilityController();

        //Availability1
        GPSD.getInstance().doLogin("aPadrao@gmail.com", "teste");
        iac.indicateNewAvailability();
        try {
            iac.newAvailabilityPeriod(new Date(2019, 3, 6), new Time(9, 0), new Date(2019, 5, 6), new Time(23, 55));
            iac.registerAvailabilityPeriod();
        } catch (IllegalArgumentException e) {
            System.out.println(GPSD.getInstance().getCurrentSession().getUserEmail() + " availability rejected");
        }
        try {
            iac.newAvailabilityPeriod(new Date(2019, 6, 24), new Time(9, 00), new Date(2019, 6, 25), new Time(13, 00));
            iac.registerAvailabilityPeriod();
        } catch (IllegalArgumentException e) {

        }
        GPSD.getInstance().getCurrentSession().doLogout();

        //Availability2
        GPSD.getInstance().doLogin("mSilva@hotmail.com", "teste");
        iac.indicateNewAvailability();
        try {
            iac.newAvailabilityPeriod(new Date(2019, 6, 6), new Time(9, 0), new Date(2019, 5, 7), new Time(23, 55));
            iac.registerAvailabilityPeriod();
        } catch (IllegalArgumentException e) {
            System.out.println(GPSD.getInstance().getCurrentSession().getUserEmail() + " availability rejected");
        }
        try {
            iac.newAvailabilityPeriod(new Date(2019, 6, 23), new Time(9, 00), new Date(2019, 6, 25), new Time(22, 00));
            iac.registerAvailabilityPeriod();
        } catch (IllegalArgumentException e) {
            System.out.println(GPSD.getInstance().getCurrentSession().getUserEmail() + " availability rejected");
        }
        try {
            iac.newAvailabilityPeriod(new Date(2019, 6, 28), new Time(18, 00), new Date(2019, 6, 30), new Time(20, 00));
            iac.registerAvailabilityPeriod();
        } catch (IllegalArgumentException e) {

        }
        GPSD.getInstance().getCurrentSession().doLogout();

        //Availability3
        GPSD.getInstance().doLogin("jaquina@hotmail.com", "teste");
        iac.indicateNewAvailability();
        try {
            iac.newAvailabilityPeriod(new Date(2019, 6, 7), new Time(9, 0), new Date(2019, 6, 10), new Time(23, 55));
            iac.registerAvailabilityPeriod();
        } catch (IllegalArgumentException e) {
            System.out.println(GPSD.getInstance().getCurrentSession().getUserEmail() + " schedule rejected");
        }
        try {
            iac.newAvailabilityPeriod(new Date(2019, 6, 28), new Time(18, 00), new Date(2019, 6, 30), new Time(20, 00));
            iac.registerAvailabilityPeriod();
        } catch (IllegalArgumentException e) {

        }
        GPSD.getInstance().getCurrentSession().doLogout();

        //Availability4
        GPSD.getInstance().doLogin("jaquina@hotmail.com", "teste");
        iac.indicateNewAvailability();
        try {
            iac.newAvailabilityPeriod(new Date(2019, 6, 28), new Time(18, 0), new Date(2019, 6, 30), new Time(20, 0));
            iac.registerAvailabilityPeriod();
        } catch (IllegalArgumentException e) {

        }
        GPSD.getInstance().getCurrentSession().doLogout();
        //Application 1
        Application one = new Application("António Patrão", 500324896, "aPatrao@gmail.com", 968795236, new PostalAddress("R. Central", new ZipCode("4415-995"), "Crestuma"));
        one.addAcadQualifications("Bachelor", "No degree", "15");
        one.addProQualification("Professional Training Course of Automotive Mechanic of the Center of Professional Training of Automotive Repair");
        one.addProQualification("Professional license for light and heavy vehicles");
        one.addProQualification("Advanced Course in Automotive Mechanics");
        one.addCategory(cat1);
        one.addCategory(cat3);
        GPSD.getInstance().getCompany().getApplicationsRegistry().addApplication(one);
        //Application 2
        Application two = new Application("Maria Silva", 510324896, "mSilva@hotmail.com", 928735537, new PostalAddress("Rue F",new ZipCode("4420-002"),"rue R"));
        two.addAcadQualifications("Bachelor", "Master", "20");
        two.addProQualification("Advanced Course of plumbing and locksmithing");
        two.addProQualification("Professional license for light and heavy vehicles");
        two.addProQualification("Cooking Course");
        two.addCategory(cat2);
        two.addCategory(cat4);
        two.addCategory(cat5);
        GPSD.getInstance().getCompany().getApplicationsRegistry().addApplication(two);
        //Application 3
        Application three = new Application("Joaquina Dos Santos", 510324877, "jaquina@hotmail", 934735567, new PostalAddress("Rua Altino Silva Gomes", new ZipCode("4470-526"), "Maia"));
        three.addAcadQualifications("Bachelor", "No degree", "18");
        three.addProQualification("Advanced Course of plumbing and locksmithing");
        three.addProQualification("Advanced Course in Automotive Mechanics");
        three.addCategory(cat1);
        three.addCategory(cat2);
        three.addCategory(cat3);
        GPSD.getInstance().getCompany().getApplicationsRegistry().addApplication(three);
        //Application 4
        Application four = new Application("Serafim Santos", 230324822, "sSantos@gmail.com", 223654987, new PostalAddress("R. Alberto Alves Tavares", new ZipCode("4430-601"), "Vila Nova De Gaia"));
        four.addAcadQualifications("High School", "No degree", "13");
        four.addProQualification("Painter Course");
        four.addCategory(cat5);
        four.addCategory(cat1);
        GPSD.getInstance().getCompany().getApplicationsRegistry().addApplication(four);
        
         //Executive Order 1
        ServiceProvider sp1 = GPSD.getInstance().getCompany().getServiceProvidersRegistry().getServiceProviderByEmail("aPadrao@gmail.com");
        ServiceProvider sp2 = GPSD.getInstance().getCompany().getServiceProvidersRegistry().getServiceProviderByEmail("mSilva@hotmail.com");
        ServiceProvider sp3 = GPSD.getInstance().getCompany().getServiceProvidersRegistry().getServiceProviderByEmail("jaquina@hotmail.com");
        ServiceRequest sr1 = GPSD.getInstance().getCompany().getServiceRequestRegistry().getServiceRequestList().get(0);
        ServiceRequest sr2 = GPSD.getInstance().getCompany().getServiceRequestRegistry().getServiceRequestList().get(3);
        ServiceRequest sr3 = GPSD.getInstance().getCompany().getServiceRequestRegistry().getServiceRequestList().get(4);
        ServiceRequest sr4 = GPSD.getInstance().getCompany().getServiceRequestRegistry().getServiceRequestList().get(5);
        Affectation a1 = new Affectation(sp1, sr1.getServReqDescList().get(0), sr1, sr1.getSchPrefList().get(1));
        Affectation a2 = new Affectation(sp2, sr2.getServReqDescList().get(0), sr2, sr2.getSchPrefList().get(0));
        Affectation a3 = new Affectation(sp3, sr3.getServReqDescList().get(0), sr3, sr3.getSchPrefList().get(0));
        Affectation a4 = new Affectation(sp3, sr4.getServReqDescList().get(0), sr4, sr4.getSchPrefList().get(0));
        ServiceOrder s1 = new ServiceOrder(a1);
        ServiceOrder s2 = new ServiceOrder(a2);
        ServiceOrder s3 = new ServiceOrder(a3);
        ServiceOrder s4 = new ServiceOrder(a4);
        GPSD.getInstance().getCompany().getServiceOrdersRegistry().getServiceOrders().add(s1);
        GPSD.getInstance().getCompany().getServiceOrdersRegistry().getServiceOrders().add(s2);
        GPSD.getInstance().getCompany().getServiceOrdersRegistry().getServiceOrders().add(s3);
        GPSD.getInstance().getCompany().getServiceOrdersRegistry().getServiceOrders().add(s4);
        ReportEndOfServiceController re = new ReportEndOfServiceController();
        RateServiceController rsc = new RateServiceController();
        rsc.showServiceList(s1.getAffectation().getServiceRequest().getClient());
        rsc.setRating(s1.getAffectation().getServiceRequestDescription(), new Rate(4));
        rsc.showServiceList(s2.getAffectation().getServiceRequest().getClient());
        rsc.setRating(s2.getAffectation().getServiceRequestDescription(), new Rate(5));
        rsc.showServiceList(s3.getAffectation().getServiceRequest().getClient());
        rsc.setRating(s3.getAffectation().getServiceRequestDescription(), new Rate(2));
        rsc.showServiceList(s4.getAffectation().getServiceRequest().getClient());
        rsc.setRating(s4.getAffectation().getServiceRequestDescription(), new Rate(2));
        re.changeToFinished(s1);
        re.changeToFinished(s2);
        re.changeToFinished(s3);
        re.addIssue(s4, "Costumer complained about the delay", "Work performed withou the presence of the client");

        
    }
}
