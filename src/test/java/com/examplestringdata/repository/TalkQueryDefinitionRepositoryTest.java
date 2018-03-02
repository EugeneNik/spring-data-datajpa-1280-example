package com.examplestringdata.repository;

import com.examplestringdata.data.Talk;
import com.examplestringdata.data.dto.IdAndDescription;
import com.examplestringdata.data.dto.IdAndDescriptionOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

@SpringBootTest
public class TalkQueryDefinitionRepositoryTest extends AbstractTransactionalTestNGSpringContextTests {

    private static final String SOME_RANDOM_TALK = "Some random talk";

    @Autowired
    private TalkQueryDefinitionRepository talkRepository;

    private Talk talk;

    @BeforeMethod
    public void setup() {
        talk = new Talk();
        talk.setName(SOME_RANDOM_TALK);
        talk = talkRepository.saveAndFlush(talk);
    }

    @Test()
    public void testFindByNameInterface() {
        IdAndDescriptionOnly resultByInterface = talkRepository.findByName(SOME_RANDOM_TALK, IdAndDescriptionOnly.class);

        assertEquals(resultByInterface.getId(), talk.getId());
        assertNull(resultByInterface.getDescription());
    }

    @Test
    public void testFindByNameClass() {
        IdAndDescription resultByClass = talkRepository.findByName(SOME_RANDOM_TALK, IdAndDescription.class);

        assertEquals(resultByClass.getId(), talk.getId());
        assertNull(resultByClass.getDescription());
    }

    @Test
    public void testFindByNameInterfaceWithoutProjection() {
        IdAndDescriptionOnly resultByInterface = talkRepository.findByNameInterface(SOME_RANDOM_TALK);

        assertEquals(resultByInterface.getId(), talk.getId());
        assertNull(resultByInterface.getDescription());
    }

    @Test
    public void testFindByNameClassWithoutProjection() {
        IdAndDescription resultByClass = talkRepository.findByNameClass(SOME_RANDOM_TALK);

        assertEquals(resultByClass.getId(), talk.getId());
        assertNull(resultByClass.getDescription());
    }
}
