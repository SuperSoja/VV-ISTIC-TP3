package fr.istic.vv;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TLSSocketFactoryTestMocks {


        private SSLSocket socketmock;
        private String[] supportedProtocolMock_1 = null;
        private String[] enabledProtocolMock_1 = null;

        @Test
        public void preparedSocket_NullProtocols()  {
            socketmock = mock(SSLSocket.class);
            when(socketmock.getSupportedProtocols()).thenReturn(supportedProtocolMock_1);
            when(socketmock.getEnabledProtocols()).thenReturn(enabledProtocolMock_1);
            doThrow(new AssertionFailedError()).when(socketmock).setEnabledProtocols(any(String[].class));
        }

        @Test
        public void typical()  {
            socketmock = mock(SSLSocket.class);
            when(socketmock.getSupportedProtocols()).thenReturn(shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}));
            when(socketmock.getEnabledProtocols()).thenReturn(shuffle(new String[]{"SSLv3", "TLSv1"}));
            new TLSSocketFactory().prepareSocket(socketmock);
            Mockito.verify(socketmock).setEnabledProtocols(new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" });
        }


        private String[] shuffle(String[] in) {
            List<String> list = new ArrayList<String>(Arrays.asList(in));
            Collections.shuffle(list);
            return list.toArray(new String[0]);
        }
}