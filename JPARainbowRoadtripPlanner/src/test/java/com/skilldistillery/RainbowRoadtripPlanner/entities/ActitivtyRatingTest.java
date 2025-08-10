package com.skilldistillery.RainbowRoadtripPlanner.entities;

import static org.junit.jupiter.api.Assertions.*;

// --- FIX: Changed imports from javax.persistence to jakarta.persistence ---
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ActitivtyRatingTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private ActivityRating activityRating;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        // This should match the persistence-unit name in your persistence.xml
        emf = Persistence.createEntityManagerFactory("JPARainbowRoadtripPlanner");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        if (emf != null) {
            emf.close();
        }
    }

    @BeforeEach
    void setUp() throws Exception {
        em = emf.createEntityManager();
        // Assuming ActivityRatingId is the composite key class
        activityRating = em.find(ActivityRating.class, new ActivityRatingId(1, 1));
    }

    @AfterEach
    void tearDown() throws Exception {
        if (em != null) {
            em.close();
        }
        activityRating = null;
    }

    @Test
    void test_ActivityRating_mappings() {
        assertNotNull(activityRating);
        assertEquals(5, activityRating.getRating());
        assertEquals("best ever", activityRating.getRatingComment());
    }
}
