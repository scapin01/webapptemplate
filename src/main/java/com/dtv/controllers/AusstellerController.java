package com.dtv.controllers;

import com.dtv.models.AusstellerRequestResult;
import com.dtv.models.PaginationModel;
import com.dtv.service.DataBaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 18.08.14
 * Time: 10:06
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class AusstellerController {



    @Autowired
    private DataBaseService dataBaseService;

    @RequestMapping(value="/aussteller", method = RequestMethod.GET)
    public ModelAndView getAussteller(HttpServletRequest request,@ModelAttribute("model") ModelMap model,
                                    @RequestParam(value = "srch-term", required = false,defaultValue="") String query,
                                    @RequestParam(value = "start", required = false,defaultValue="0") int start,
                                    @RequestParam(value = "max", required = false,defaultValue="50") int max)
    {

        AusstellerRequestResult p = dataBaseService.searchAussteller(query, start, max);
        model.put("aussteller",p.getAussteller());
        model.put("numFound",p.getNumFound());

        model.put("start",start);
        model.put("max",max);

        if(StringUtils.isNotEmpty(query)){
            model.put("query",query);
        }

        //Pagination Model
        //define currentPage. max is the number of item per page
        //Page 1 is first Page

        int pageIndex = start/max +1 ;
        model.put("pageIndex",pageIndex);
        List<PaginationModel> pagesIndexes = new ArrayList<PaginationModel>();
        int d = (int) Math.ceil((double)p.getNumFound() / max);
        for(int i=1;i<=d;i++){

            PaginationModel paginationModel = new PaginationModel();
            paginationModel.setPageIndex(i);
            paginationModel.setStart(max * (i - 1));
            paginationModel.setMax(max);
            pagesIndexes.add(paginationModel);
        }
        model.put("pagesIndexes",pagesIndexes);
        return new ModelAndView("aussteller/aussteller.ftl",model);
    }



    /*@RequestMapping(value="/add_aussteller", method = RequestMethod.GET)
    public ModelAndView addAussteller(HttpServletRequest request)
    {


        Aussteller aus = new Aussteller();
        aus.setOrganization("Holiday Insider AG");
        aus.setEmail("florian.bessiere@holidayinsider.com");
        aus.setLogo("logo_orange@2x.png");
        aus.setAddress("Linprunstr. 16 80335 München");
        aus.setWebsite("http://www.holidayinsider.com");
        aus.setTextInfo("HolidayInsider bietet als Plattform Nummer 1 die größte Auswahl und Vielfalt an Unterkünften für Urlaub in Deutschland und Europa. HolidayInsider ist ein führendes Technologieunternehmen mit touristischem Know-how und die Plattform Nummer 1 für Reisende und Unterkunftsanbieter.");
        aus.setPhone("+491111116686");
        morphium.store(aus);


        Aussteller aus3 = new Aussteller();
        aus3.setOrganization("Europapark");
        aus3.setEmail("florian.bessiere@holidayinsider.com");
        aus3.setLogo("logo_orange@2x.png");
        aus3.setAddress("Linprunstr. 16 80335 München");
        aus3.setWebsite("http://www.europapark.de");
        aus3.setTextInfo("Im Herzen Europas, zwischen Schwarzwald und Vogesen, liegt einer der schönsten Freizeitparks der Welt. Knapp 5 Millionen Besucher aller Nationen kommen jede Saison, um sich von über einhundert Attraktionen und Shows begeistern zu lassen. Das innovative europäische Themenkonzept, das größte zusammenhängende Hotelresort Deutschlands, den Jahreszeiten angepasste Dekorationen und eine Vielzahl abwechslungsreicher und bunter Events machen den Europa-Park das ganze Jahr über zu einer unverwechselbaren und einzigartigen Kurzurlaubsdestination.");
        aus3.setPhone("+491rtzu67iujhgf");
        morphium.store(aus3);

        Aussteller aus4 = new Aussteller();
        aus4.setOrganization("Freiburg Tousismus");
        aus4.setEmail("florian.bessiere@holidayinsider.com");
        aus4.setLogo("logo_orange@2x.png");
        aus4.setAddress("Linprunstr. 16 80335 München");
        aus4.setWebsite("http://www.freiburg.de");
        aus4.setTextInfo("HolidayInsider bietet als Plattform Nummer 1 die größte Auswahl und Vielfalt an Unterkünften für Urlaub in Deutschland und Europa. HolidayInsider ist ein führendes Technologieunternehmen mit touristischem Know-how und die Plattform Nummer 1 für Reisende und Unterkunftsanbieter.");
        aus4.setPhone("+491111115895966");
        morphium.store(aus4);


        return new ModelAndView("index.ftl");
    }*/

}
