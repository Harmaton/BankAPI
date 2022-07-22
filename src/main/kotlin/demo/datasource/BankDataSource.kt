package demo.datasource

import demo.model.Bank

interface BankDataSource {
    fun getBanks(): Collection<Bank>
}
