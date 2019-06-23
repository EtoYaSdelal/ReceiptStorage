package app.controller;

import app.model.Receipt;
import app.repository.ReceiptRepository;
import app.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class ReceiptController {


    @Autowired
    private ReceiptService receiptService;


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
    public ModelAndView editReceipt(@ModelAttribute("receipt") @Valid Receipt receipt, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/edit");
            return modelAndView;
        }
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
    public ModelAndView addReceipt(@ModelAttribute("receipt") @Valid Receipt receipt, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/add");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/");
        checkField(receipt);
        receiptService.addReceipt(receipt);
        return modelAndView;
    }

    private void checkField(@ModelAttribute("receipt") Receipt receipt) {

        if (receipt.getTime() == null) {
            receipt.setTime(LocalTime.now());
        }
        if (receipt.getDate() == null) {
            receipt.setDate(LocalDate.now());
        }
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

    @InitBinder("receipt")
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Receipt.class, "serverId", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                String paymentPattern = "^\\d*\\.\\d+$";
                Pattern pattern = Pattern.compile(paymentPattern);
                Matcher matcher = pattern.matcher(text);
                if (!matcher.matches()) {
                    setValue("");
                } else {
                    setValue(Double.parseDouble(text));
                }
            }
        });
    }
}