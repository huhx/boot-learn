#### json serialization and deserialization
https://www.baeldung.com/spring-boot-jsoncomponent


### json deserializer
public class UserJsonDeserializer extends JsonDeserializer<User> {

  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public User deserialize(JsonParser parser, DeserializationContext context)
      throws IOException {

    TreeNode treeNode = parser.getCodec().readTree(parser);
    String username = ((TextNode) treeNode.get("username")).asText();
    String password = ((TextNode) treeNode.get("password")).asText();
    Address address = objectMapper.readValue(((ObjectNode) treeNode.get("address")).asText(), Address.class);

    return new User(username, password, address);
  }
}
