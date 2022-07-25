package demo.controller

import demo.BankService.BankService
import demo.model.Bank
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.IllegalArgumentException

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {

    //exception handling

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleNotFound(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    // get mapping
    @GetMapping
    fun getBanks() : Collection<Bank> = service.getBanks()

    @GetMapping("/{accountNumber}")
    fun getBank(@PathVariable accountNumber: String) = "You want data about $accountNumber"
        ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")

    // post mapping
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun addBank(@RequestBody bank: Bank): Bank = service.addBank(bank)

    //patch mapping
    @PatchMapping
    fun updateBank(@RequestBody bank: Bank): Bank = service.updateBank(bank)
}