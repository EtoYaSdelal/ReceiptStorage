package app.controller;

import app.dao.DaoReceiptImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StoreController {

    private static DaoReceiptImpl daoReceipt;

    static {
        daoReceipt = new DaoReceiptImpl();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allModels() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list");
        modelAndView.addObject("receipts", daoReceipt.getAllReceipts());
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        return modelAndView;
    }
}
