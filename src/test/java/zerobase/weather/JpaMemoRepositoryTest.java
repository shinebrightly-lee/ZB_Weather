package zerobase.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JpaMemoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class JpaMemoRepositoryTest {

    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
    // given
        Memo newMemo = new Memo(10, "this is jpa memo!");
    // when
        jpaMemoRepository.save(newMemo);
    // then
        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(memoList.size() > 0);
    }

    @Test
    void findByIdTest() {
    // given
        Memo newMemo = new Memo(11,"jpa"); // 자동으로 id 를 올리게 만들어서 수기로 작성하는게 의미 X
    // when
        Memo memo = jpaMemoRepository.save(newMemo);
        System.out.println(memo.getId());
        // then
        Optional<Memo> result = jpaMemoRepository.findById(memo.getId()); // memo 를 받아서 getId() 를 해야 id 값을 알 수 있음
        assertEquals(result.get().getText(),"jpa");
    }
}
