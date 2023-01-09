import "bootstrap/dist/css/bootstrap.min.css";
import "../../styles/mediaQueries.css";
import type { AppProps } from 'next/app'
import SSRProvider from "react-bootstrap/SSRProvider";

export default function App({ Component, pageProps }: AppProps) {
  return (
  <SSRProvider>
    <Component {...pageProps} />
  </SSRProvider>
  )
}
