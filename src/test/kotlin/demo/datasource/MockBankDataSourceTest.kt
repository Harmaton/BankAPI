package demo.datasource

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class MockBankDataSourceTest {

    private val mockDataSource : MockBankDataSource = MockBankDataSource()

    @Test
    fun `should provide a collection of banks` (){
        //given /range

        //when /act
        val banks = mockDataSource.getBanks()
        //then /assert
        Assertions.assertThat(banks).isNotEmpty
        assertThat(banks.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should provide some data` (){

        //when
        val banks = mockDataSource.getBanks()

        //then
        assertThat(banks).allMatch{it.accountNumber.isNotBlank()}
        assertThat(banks).anyMatch{it.trust != 0.0}
    }



}
        