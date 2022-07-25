package demo.controller

import demo.BankService.BankService
import demo.model.Bank
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {

    @GetMapping
    fun getBanks() : Collection<Bank> = service.getBanks()

    @GetMapping("/{accountNumber}")
    fun getBank(@PathVariable accountNumber: String) = "You want data about $accountNumber"
        ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun addBank(@RequestBody bank: Bank): Bank = service.addBank(bank)
}