(ns tree_reparenting_test
  (:use clojure.test)
  (:use tree_reparenting))


(deftest test-1
  (is (= '(n)
        (reconnect 'n '(n)))))

(deftest test-2
  (is (= '(a (t (e)))
        (reconnect 'a '(t (e) (a))))))

(deftest test-3
  (is (= '(e (t (a)))
        (reconnect 'e '(a (t (e)))))))

(deftest test-4
  (is (= '(a (b (c)))
        (reconnect 'a '(c (b (a)))))))

(deftest test-5
  (is (= '(d
            (b
              (c)
              (e)
              (a
                (f
                  (g)
                  (h)))))
        (reconnect 'd '(a
                  (b
                    (c)
                    (d)
                    (e))
                  (f
                    (g)
                    (h)))))))

(deftest test-6
  (is (= '(c
            (d)
            (e)
            (b
              (f
                (g)
                (h))
              (a
                (i
                  (j
                    (k)
                    (l))
                  (m
                    (n)
                    (o))))))
        (reconnect 'c '(a
                  (b
                    (c
                      (d)
                      (e))
                    (f
                      (g)
                      (h)))
                  (i
                    (j
                      (k)
                      (l))
                    (m
                      (n)
                      (o))))))
    ))

(run-tests 'tree_reparenting_test)