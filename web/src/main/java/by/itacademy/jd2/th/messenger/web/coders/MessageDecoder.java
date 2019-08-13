package by.itacademy.jd2.th.messenger.web.coders;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;

public class MessageDecoder implements Decoder.Text<IMessage> {
	public static Gson gson = new Gson();

	@Override
	public void init(EndpointConfig config) {
		throw new RuntimeException("Not implementet");

	}

	@Override
	public void destroy() {
		throw new RuntimeException("Not implementet");

	}

	@Override
	public IMessage decode(String s) throws DecodeException {
		return gson.fromJson(s, IMessage.class);
	}

	@Override
	public boolean willDecode(String s) {
		return s != null;
	}

}
