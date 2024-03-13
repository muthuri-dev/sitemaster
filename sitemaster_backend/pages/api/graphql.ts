//The graphql server

import { startServerAndCreateNextHandler } from "@as-integrations/next";
import { typeDefs } from "@/graphql/schema";
import { resolvers } from "@/graphql/resolvers";
import { ApolloServer } from "@apollo/server";
import { NextApiRequest, NextApiResponse } from "next";
import { TContext } from "@/types";
import prisma from "@/utils/db";
import allowCors from "@/utils/cors";

const apolloServer = new ApolloServer<TContext>({
  typeDefs,
  resolvers,
  introspection: true,
});
const handler = startServerAndCreateNextHandler(apolloServer, {
  context: async (req: NextApiRequest, res: NextApiResponse) => ({
    req,
    res,
    prisma,
  }),
});
export default allowCors(handler);
