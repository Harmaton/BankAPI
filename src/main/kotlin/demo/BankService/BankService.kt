package demo.BankService

import demo.datasource.BankDataSource
import demo.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {

fun getBanks(): Collection<Bank> = dataSource.getBanks()

fun getBank(accountNumber: String): Bank = dataSource.getBank(accountNumber)

    fun addBank(bank: Bank): Bank = dataSource.createBank(bank)


}