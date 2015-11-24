package account.web;

import account.domain.Customer;
import account.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
class AccountController {

    @Autowired
    protected AccountService accountService;

    
    // curl -i -H 'Accept: application/json' http://localhost:8080/accounts?name=TheCustomerName
    // curl -i http://localhost:8080/accounts?name=TheCustomerName
    // curl -i -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"name":"TheCustomerName"}' http://localhost:8080/accounts\
    // curl -i -H 'Content-Type: application/json' -d '{"name":"TheCustomerName"}' http://localhost:8080/accounts


    @RequestMapping(value="/accounts")
    public String listWithRequestParams(Customer customer, Model model) {
        return listInternal(customer, model);
    }

    @RequestMapping(value="/accounts", consumes="application/json")
    public String listWithRequestBody(@RequestBody Customer customer, Model model) {
        return listInternal(customer, model);
    }

    private String listInternal(Customer customer, Model model) {
        model.addAttribute("accounts", accountService.findAllAccounts(customer.getName()) );
        return "accounts/list";
    }

}