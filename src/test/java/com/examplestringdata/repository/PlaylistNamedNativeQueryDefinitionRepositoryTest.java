package com.examplestringdata.repository;

import com.examplestringdata.data.Playlist;
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
public class PlaylistNamedNativeQueryDefinitionRepositoryTest extends AbstractTransactionalTestNGSpringContextTests {

    private static final String SOME_RANDOM_PLAYLIST = "Some random playlist";

    @Autowired
    private PlaylistNamedNativeQueryDefinitionRepository playlistsRepository;

    private Playlist playlist;

    @BeforeMethod
    public void setup() {
        playlist = new Playlist();
        playlist.setName(SOME_RANDOM_PLAYLIST);
        playlist = playlistsRepository.saveAndFlush(playlist);
    }

    @Test
    public void testFindByNameInterface() {
        IdAndDescriptionOnly resultByInterface = playlistsRepository.findByName(SOME_RANDOM_PLAYLIST, IdAndDescriptionOnly.class);

        assertEquals(resultByInterface.getId(), playlist.getId());
        assertNull(resultByInterface.getDescription());
    }

    @Test
    public void testFindByNameClass() {
        IdAndDescription resultByClass = playlistsRepository.findByName(SOME_RANDOM_PLAYLIST, IdAndDescription.class);

        assertEquals(resultByClass.getId(), playlist.getId());
        assertNull(resultByClass.getDescription());
    }

    @Test
    public void testFindByNameInterfaceWithoutProjection() {
        IdAndDescriptionOnly resultByInterface = playlistsRepository.findByNameInterface(SOME_RANDOM_PLAYLIST);

        assertEquals(resultByInterface.getId(), playlist.getId());
        assertNull(resultByInterface.getDescription());
    }

    @Test
    public void testFindByNameClassWithoutProjection() {
        IdAndDescription resultByClass = playlistsRepository.findByNameClass(SOME_RANDOM_PLAYLIST);

        assertEquals(resultByClass.getId(), playlist.getId());
        assertNull(resultByClass.getDescription());
    }
}
