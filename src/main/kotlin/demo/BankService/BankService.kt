package demo.BankService

import demo.datasource.BankDataSource
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {


}