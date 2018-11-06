namespace java org.mine


struct Log {
  1:  i16 v;
  2:  i64 time;
  3:  string m;

}


service LogService {
  void getLog(1: Log log );
}
