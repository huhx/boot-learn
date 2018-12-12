package com.linux.huhx.json.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import com.linux.huhx.domain.Address;
import com.linux.huhx.domain.User;
import java.io.IOException;

public class UserJsonDeserializer extends JsonDeserializer<User> {

  @Override
  public User deserialize(JsonParser parser, DeserializationContext context)
      throws IOException {

    TreeNode treeNode = parser.getCodec().readTree(parser);
    String username = ((TextNode) treeNode.get("username")).asText();
    String password = ((TextNode) treeNode.get("password")).asText();
    Address address = getAddressFromString(((TextNode) treeNode.get("address")).asText());
    return new User(username, password, address);
  }

  private Address getAddressFromString(String address) {
    String[] strings = address.split("-");
    return new Address(strings[0], strings[1], strings[2]);
  }
}
