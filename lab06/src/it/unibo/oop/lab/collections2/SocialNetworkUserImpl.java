package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */

    private Map<String, Set<U>> follower;
    
    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     */
     

    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        this.follower = new HashMap<>();
    }
    
    /* 
     * 2) Define a further constructor where age is defaulted to -1
     */
    
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        this(name, surname, user, -1);
    }

    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

    public boolean addFollowedUser(final String circle, final U user) {
        Set<U> groupFollower = this.follower.get(circle);
        if(groupFollower == null) {
            groupFollower = new HashSet<>();
            this.follower.put(circle, groupFollower);
        }
        return groupFollower.add(user);
    }

    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        final Set<U> groupFollower = this.follower.get(groupName);
        if(groupFollower != null) {
        	return new ArrayList<>(groupFollower);
        }
	return Collections.emptyList();
    }

    @Override
    public List<U> getFollowedUsers() {
        final List<U> followers = new ArrayList<>();
        for(final Set<U> g : follower.values()) {
            followers.addAll(g);
        }
	return followers;
    }

}
