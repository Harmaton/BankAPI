package demo.datasource

import demo.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {
    val banks = mutableListOf(
        Bank("1234",0.0,0),
        Bank("4567",10.0,12),
        Bank("8910",200.0,67)
    )

    override fun getBanks(): Collection<Bank> = banks


    override fun getBank(accountNumber: String): Bank =
        banks.first{it.accountNumber == accountNumber}


    override fun createBank(bank: Bank): Bank {
        banks.add(bank)

        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = banks.firstOrNull { it.accountNumber == bank.accountNumber }
            ?: throw  NoSuchElementException("")
        banks.remove(currentBank)
        banks.add(bank)

        return bank
    }


}