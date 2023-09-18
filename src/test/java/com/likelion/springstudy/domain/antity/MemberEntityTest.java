package com.likelion11.springstudy.domain.entity;

        import com.likelion11.springstudy.repository.MemberJpaRepository;
        import org.assertj.core.api.Assertions;
        import org.junit.jupiter.api.DisplayName;
        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberEntityTest {
    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Test @DisplayName("test")
    public void test(){
        //given

        MemberEntity member = MemberEntity.builder()
                .id(1L)
                .username("unanchoi")
                .nickname("unanunan")
                .password("password")
                .build();
        //when
        memberJpaRepository.save(member);
        MemberEntity findMember = memberJpaRepository.findById(1L).get();
        //then

        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
    }
}