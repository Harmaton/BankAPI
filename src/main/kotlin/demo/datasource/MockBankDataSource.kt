package demo.datasource

import demo.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {
    val banks = listOf(
        Bank("dkdh",0.0,0),
        Bank("ugd",10.0,12),
        Bank("jhks",2.0,67)
    )

    override fun getBanks(): Collection<Bank> = banks

}