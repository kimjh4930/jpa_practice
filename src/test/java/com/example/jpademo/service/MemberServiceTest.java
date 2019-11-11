package com.example.jpademo.service;

import com.example.jpademo.domain.Member;
import com.example.jpademo.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    public void testAddNewMember() {

        System.out.println("testAddNewMember()");

        Member member = new Member();
        member.setUsername("Member1");
        memberRepository.save(member);
    }

}
