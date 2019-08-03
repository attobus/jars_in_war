package demo.jars_in_war.method1.controller;

/**
 * The data class for the rest end point B.
 * It will be sent as a response for requests to the /methodB
 */
public class DataB {

	/**
	 * The id for the data entry
	 */
    private final long id;
    
    /**
     * The content of the data entry
     */
    private final String content;

    /**
     * The constructor of the data entry
     * @param id - the id for the data entry
     * @param content - content of the data entry
     */
    public DataB(long id, String content) {
        this.id = id;
        this.content = content;
    }

    // Getters    
    
    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
