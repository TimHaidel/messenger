package by.itacademy.jd2.th.messenger.web.coders;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;

public class MessageEncoder implements Encoder.Text<IMessage> {
	private static Gson gson = new Gson();

	@Override
	public void init(EndpointConfig config) {
		throw new RuntimeException("Not implementet");
	}

	@Override
	public void destroy() {
		throw new RuntimeException("Not implementet");
	}

	@Override
	public String encode(IMessage message) throws EncodeException {
		return gson.toJson(message);
	}

}
