TOTAL = 6
current = 1
m = Mutex.new
cv = (0..2).map { ConditionVariable.new }
main_cv = ConditionVariable.new
ready_count = 0

threads = (0..2).map do |i|
  Thread.new do
    m.synchronize do

      # more robust version for invoke thread 0
      ready_count += 1
      main_cv.signal
      # end

      loop do
        puts "begin waiting in thread #{i}"
        cv[i].wait(m)
        if (current > TOTAL)
          cv[(i+1) % 3].signal
          break
        end
        puts "In thread #{i} -- #{Thread.current} -- #{current}"
        current += 1
        cv[(i+1) % 3].signal # if this is excuted before another thread is waiting, then another thread will waiting forever..... deadlock
                             # so make sure all the threads are waiting for signal in the main thread
      end
    end
  end
end

# naive version
# sleep(1) # wait for all the threads to be ready
# cv[0].signal
# or use this more robust version
m.synchronize do
  while (ready_count < 3) do # make sure all the threads are ready
    main_cv.wait(m)
  end
  cv[0].signal
end

threads.each { |t| t.join }

# !!!!important
# in java. we can use similar methods to accomplish the same effect.
# but we also can Semaphore, and totally get rid of "synchronize" keyword.
# See "Main5" in chap18 for a similar problem which is solved in java
