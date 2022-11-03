package demo.datasource

import org.assertj.core.api.Assertions
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
    }


}
        