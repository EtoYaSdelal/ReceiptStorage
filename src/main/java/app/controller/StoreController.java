package app.controller;

import app.model.Receipt;
import app.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class StoreController {

    private final ReceiptService receiptService;

    @Autowired
    public StoreController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allModels() {
        ModelAndView modelAndView = new ModelAndView();
        List<Receipt> allReceipts = receiptService.getAllReceipts();
        modelAndView.setViewName("list");
        modelAndView.addObject("receipts", allReceipts);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") String id) {
        Receipt receipt = receiptService.getReceipt(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("receipt", receipt);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editReceipt(@ModelAttribute("receipt") Receipt receipt) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        receiptService.editReceipt(receipt);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("receipt", new Receipt());
        modelAndView.setViewName("add");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addReceipt(@ModelAttribute("receipt") Receipt receipt) throws IllegalArgumentException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        if (receipt.getTime() == null) {
            receipt.setTime(LocalTime.now());
        }
        if (receipt.getDate() == null) {
            receipt.setDate(LocalDate.now());
        }
        System.out.println(receipt.getPayment() + " bool " + receipt.isPaid());
        receiptService.addReceipt(receipt);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteReceipt(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");

        receiptService.deleteReceipt(receiptService.getReceipt(id));
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    @GetMapping(value = "/error")
    public ModelAndView allExceptionHandler(HttpServletRequest req, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", req.getRequestURL());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @RequestMapping(value = "/", params = "show", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView showDebtors(@RequestParam(value = "show") String action) {
        ModelAndView modelAndView = new ModelAndView();
        switch (action) {
            case "debtors":
                modelAndView.setViewName("list");
                modelAndView.addObject("receipts", receiptService.showDebtors());
                break;
            case "sortByName":
                modelAndView.setViewName("list");
                modelAndView.addObject("receipts", receiptService.sortByName());
                break;
        }

        return modelAndView;
    }

}
