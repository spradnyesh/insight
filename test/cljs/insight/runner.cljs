(ns insight.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [insight.core-test]))

(doo-tests 'insight.core-test)
