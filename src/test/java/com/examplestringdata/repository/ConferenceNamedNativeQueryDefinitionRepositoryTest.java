package com.examplestringdata.repository;

import com.examplestringdata.data.Conference;
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
public class ConferenceNamedNativeQueryDefinitionRepositoryTest extends AbstractTransactionalTestNGSpringContextTests {

    private static final String SOME_RANDOM_CONFERENCE = "Some random conference";

    @Autowired
    private ConferenceNamedNativeQueryDefinitionRepository conferenceRepository;

    private Conference conference;

    @BeforeMethod
    public void setup() {
        conference = new Conference();
        conference.setName(SOME_RANDOM_CONFERENCE);
        conference = conferenceRepository.saveAndFlush(conference);
    }

    @Test
    public void testFindByNameInterface() {
        IdAndDescriptionOnly resultByInterface = conferenceRepository.findByName(SOME_RANDOM_CONFERENCE, IdAndDescriptionOnly.class);

        assertEquals(resultByInterface.getId(), conference.getId());
        assertNull(resultByInterface.getDescription());
    }

    @Test
    public void testFindByNameClass() {
        IdAndDescription resultByClass = conferenceRepository.findByName(SOME_RANDOM_CONFERENCE, IdAndDescription.class);

        assertEquals(resultByClass.getId(), conference.getId());
        assertNull(resultByClass.getDescription());
    }

    @Test
    public void testFindByNameInterfaceWithoutProjection() {
        IdAndDescriptionOnly resultByInterface = conferenceRepository.findByNameInterface(SOME_RANDOM_CONFERENCE);

        assertEquals(resultByInterface.getId(), conference.getId());
        assertNull(resultByInterface.getDescription());
    }

    @Test
    public void testFindByNameClassWithoutProjection() {
        IdAndDescription resultByClass = conferenceRepository.findByNameClass(SOME_RANDOM_CONFERENCE);

        assertEquals(resultByClass.getId(), conference.getId());
        assertNull(resultByClass.getDescription());
    }
}
