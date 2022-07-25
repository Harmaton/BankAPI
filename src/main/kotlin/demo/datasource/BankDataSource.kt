package demo.datasource

import demo.model.Bank

interface BankDataSource {

    fun getBanks(): Collection<Bank>

    fun getBank(accountNumber: String): Bank

    fun createBank(bank: Bank): Bank

     fun updateBank(bank: Bank): Bank
}
